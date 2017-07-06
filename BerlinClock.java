public class BerlinClock {

        private final String SECOND = "Y";
        private final String HOUR = "R";
        private final String QUART="R";
        private final String MINUTE="Y";
        private final String BLANK="O";

        public String getSeconds(int secs){
                String seconds="";
                for(int i=0;i<(secs/2);i++){
                        seconds+=SECOND;
                }
                return seconds;
        }

        public String getHoursRow(int hh){
                String hours = "";
                for(int i=0;i<hh;i++){
                        hours+=HOUR;
                }
                return hours;
        }

        public String getHours(int hh){
                String hours="";

                int h1= hh/5;
                int h2 = hh%5;
                hours+=getHoursRow(h1)+"\n";
                hours+=getHoursRow(h2)+"\n";

                return hours;
        }

        public String getQuarter(int quarter){
                String quart = "";
                int qrt = quarter/15;
                for(int i=0;i<qrt;i++){
                        quart+=QUART;
                }
                return quart;
        }

        public String getMinutes(int mins){
                String minutes="";

                if (mins > 15) {
                        minutes += getQuarter(mins);
                }

                int min = mins / 5;

                if(min<5){
                        for (int i = 0; i < min; i++) {
                                minutes += MINUTE;
                        }
                }
                else{
			//TODO
                }


                return minutes;
        }

        public String getTime(String input){
                String time="";

                String tokens[] = input.split(":");

                int hh= Integer.parseInt(tokens[0]);
                int mm = Integer.parseInt(tokens[1]);
                int ss = Integer.parseInt(tokens[2]);

                time+=getSeconds(ss)+"\n";
                time+=getHours(hh);
                time+=getMinutes(mm);

                return time;
        }

        public static void main(String[] args) {
                BerlinClock clk = new BerlinClock();
                System.out.println(clk.getTime("13:35:08"));
        }
}