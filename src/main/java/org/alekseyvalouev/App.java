package org.alekseyvalouev;




public class App {
    public static void main( String[] args ) {
        CompetitionList nationalComps = new CompetitionList("https://member.usafencing.org/search/tournaments/national?search=&filter_by_weapon=1&filter_by_gender=3&event_scopes=&filter_by_type=&filter_by_event_type=&filter_by_show=future&designated=");
        CompetitionList regionalComps = new CompetitionList("https://member.usafencing.org/search/tournaments/regional?search=&filter_by_region=all&filter_by_weapon=1&filter_by_gender=3&event_scopes=&filter_by_type=&filter_by_event_type=&filter_by_show=future&designated=");
        System.out.println("National Competitions: ");
        for (Competition E : nationalComps.getCompetitionList()) {
            System.out.println(E.getFullInfo());
            System.out.println("============");
        }
        System.out.println("Regional Competitions: ");
        for (Competition E : regionalComps.getCompetitionList()) {
            System.out.println(E.getFullInfo());
            System.out.println("============");
        }
    }
}
