package org.alekseyvalouev;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class CompetitionList {
    private String mUrl;

    public CompetitionList(String url) {
        mUrl = url;
    }

    public ArrayList<Competition> getCompetitionList() {
        ArrayList<Competition> Competitions = new ArrayList<>();
        try {
            Element tableBody = null;

            Document doc = Jsoup.connect(mUrl).get();

            //table class
            Elements entryTable = doc.getElementsByClass("table");

            int i = 0;
            //go through table find first table in document
            for (Element tableElement : entryTable) {
                //first table found
                if (i == 0) {
                    Element subTableElement = tableElement.child(0);
                    tableBody = subTableElement.child(1);
                }
                i+=1;
            }

            Elements tableEntries = tableBody.children();

            for (Element dataEntry : tableEntries) {
                Elements entryInfo = dataEntry.children();

                String compName = null, compDate = null, compRegDate = null, compLoc = null;

                i = 0;
                for (Element info : entryInfo) {
                    if (info.hasText()) {
                        if (i == 1) {
                            Elements regDateAndName = info.children();
                            int k = 0;
                            for (Element j : regDateAndName) {
                                if (j.hasText()) {
                                    if (k == 0) {
                                        compName = j.text();
                                    } else if (k == 1) {
                                        compRegDate = j.text();
                                    }
                                }
                                k+=1;
                            }
                        } else if (i!=3) {
                            if (i == 0) {
                                compDate = info.text();
                            } else if (i == 2) {
                                compLoc = info.text();
                            }
                        } else {
                            Competition newComp = new Competition(compName, compLoc, compDate, compRegDate);
                            Competitions.add(newComp);
                        }
                        i+=1;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Competitions;
    }
}
