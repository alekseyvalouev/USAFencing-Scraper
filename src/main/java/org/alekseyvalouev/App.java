package org.alekseyvalouev;


import java.io.IOException;
import java.util.ArrayList;

public class App {
    public static void updateCompFile(StorageWriter mWriter, String filename, CompetitionList comp) throws IOException{
        mWriter.setFilename(filename);
        mWriter.write(comp.getCompetitionList());
    }

    public static ArrayList<Competition> getNewComps(String filename, CompetitionList comp) throws IOException, ClassNotFoundException {
        ArrayList<Competition> tempList = new ArrayList<>();
        StorageWriter mStorageWriter = new StorageWriter();
        if (comp.getCompetitionList().size() > 0) {
            StorageReader mStorageReader = new StorageReader();
            mStorageReader.setFilename(filename);
            ArrayList<Competition> oldNatComps = mStorageReader.read();
            ArrayList<Competition> newNatComps = comp.getCompetitionList();

            for (Competition E : newNatComps) {
                boolean matches = false;
                for (Competition F : oldNatComps) {
                    if (F.getFullInfo().equals(E.getFullInfo())) {
                        matches = true;
                    }
                }
                if (matches == false) {
                    tempList.add(E);
                }
            }
        }
        updateCompFile(mStorageWriter, filename, comp);
        return tempList;
    }

    public static void main( String[] args ) throws IOException, ClassNotFoundException {
        StorageWriter mStorageWriter = new StorageWriter();
        StorageReader mStorageReader = new StorageReader();

        String mRegionalUrl = "https://member.usafencing.org/search/tournaments/regional?search=&filter_by_region=4&filter_by_weapon=1&filter_by_gender=3&event_scopes=&filter_by_type=&filter_by_event_type=&filter_by_show=future&designated=";
        String mSYCUrl = "https://member.usafencing.org/search/tournaments/regional?search=&filter_by_region=all&filter_by_weapon=1&filter_by_gender=3&event_scopes=syc&filter_by_type=&filter_by_event_type=&filter_by_show=future&designated=";
        String mNationalUrl = "https://member.usafencing.org/search/tournaments/national?search=&filter_by_weapon=1&filter_by_gender=3&event_scopes=&filter_by_type=&filter_by_event_type=&filter_by_show=future&designated=";
        String mSJCUrl = "https://member.usafencing.org/search/tournaments/regional?search=&filter_by_region=all&filter_by_weapon=1&filter_by_gender=3&event_scopes=sjc&filter_by_type=&filter_by_event_type=&filter_by_show=future&designated=";
        String mSCCUrl = "https://member.usafencing.org/search/tournaments/regional?search=&filter_by_region=all&filter_by_weapon=1&filter_by_gender=3&event_scopes=scc&filter_by_type=&filter_by_event_type=&filter_by_show=future&designated=";

        CompetitionList mNationalComps = new CompetitionList(mNationalUrl);
        CompetitionList mRegionalComps = new CompetitionList(mRegionalUrl);
        CompetitionList mSYC = new CompetitionList(mSYCUrl);
        CompetitionList mSJC = new CompetitionList(mSJCUrl);
        CompetitionList mSCC = new CompetitionList(mSCCUrl);

        ArrayList<Competition> mNewNatComps = getNewComps("NationalStorage", mNationalComps);
        ArrayList<Competition> mNewRegComps = getNewComps("RegionalStorage", mRegionalComps);
        ArrayList<Competition> mNewSCCComps = getNewComps("SCCStorage", mSCC);
        ArrayList<Competition> mNewSJCComps = getNewComps("SJCStorage", mSJC);
        ArrayList<Competition> mNewSYCComps = getNewComps("SYCStorage", mSYC);

        System.out.println();
        System.out.println("National Competitions");
        for (Competition E : mNewNatComps) {
            System.out.println("====");
            System.out.println(E.getFullInfo());
        }
        System.out.println();
        System.out.println("Regional Competitions");
        for (Competition E : mNewRegComps) {
            System.out.println("====");
            System.out.println(E.getFullInfo());
        }
        System.out.println();
        System.out.println("SCC Competitions");
        for (Competition E : mNewSCCComps) {
            System.out.println("====");
            System.out.println(E.getFullInfo());
        }
        System.out.println();
        System.out.println("SJC Competitions");
        for (Competition E : mNewSJCComps) {
            System.out.println("====");
            System.out.println(E.getFullInfo());
        }
        System.out.println();
        System.out.println("SYC Competitions");
        for (Competition E : mNewSYCComps) {
            System.out.println("====");
            System.out.println(E.getFullInfo());
        }
    }
}
