
package sptv20yearsweather;

import java.util.Random;
import java.util.Scanner;

public class SPTV20YearsWeather {
    public static enum month{
        Январь, Февраль, Март, Апрель, Май, Июнь, Июль, Август, 
        Сентябрь, Октябрь, Ноябрь, Декабрь
    }
    public static void main(String[] args) {
        Random random = new Random();
        int min = -20, max = 20, dayInMonth = 0, tMax = -40, tMin = 40;
        
//Зубчатый массив
        int[][] yearsWeather = new int[12][];
        System.out.print("         ");
//numeracija dnej
        for (int i = 0; i < 31; i++) {
            System.out.printf("%4d",i+1);
        }
        
        System.out.println("");
        for (int i = 0; i < 135; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < yearsWeather.length; i++) {
            switch (i) {
                case 0: min=-20;max=-5; dayInMonth=31; break;
                case 1: min=-15;max=0; dayInMonth=28; break;
                case 2: min=-10;max=5; dayInMonth=31; break;
                case 3: min=-5;max=10; dayInMonth=30; break;
                case 4: min=0;max=15; dayInMonth=31; break;
                case 5: min=10;max=20; dayInMonth=30; break;
                case 6: min=15;max=25; dayInMonth=31; break;
                case 7: min=10;max=20; dayInMonth=31; break;
                case 8: min=5;max=15; dayInMonth=30; break;
                case 9: min=-5;max=10; dayInMonth=31; break;
                case 10: min=-10;max=5; dayInMonth=30; break;
                case 11: min=-15;max=0; dayInMonth=31; break;
            }
            
            yearsWeather[i] = new int[dayInMonth];
            double sum = 0.0;
            System.out.printf("%8s:",month.values()[i]);
            for (int j = 0; j < yearsWeather[i].length; j++) {
                yearsWeather[i][j]=random.nextInt(max-min+1)+min;
                sum+=yearsWeather[i][j];
                if(tMax < yearsWeather[i][j]){
                    tMax = yearsWeather[i][j];
                }
                System.out.printf("%4d",yearsWeather[i][j]);
            }
            
            if(dayInMonth <29){
                System.out.printf("                средняя t = %6.2f%n",sum/dayInMonth);
            }else if(dayInMonth>29 && dayInMonth < 31){
                System.out.printf("        средняя t = %6.2f%n",sum/dayInMonth);
            }else if(dayInMonth > 30){
                System.out.printf("    средняя t = %6.2f%n",sum/dayInMonth);
            }
            
        }
        System.out.println();
        for (int i = 0; i < yearsWeather.length; i++) {
            for (int j = 0; j < yearsWeather[i].length; j++) {
                if(tMax < yearsWeather[i][j]){
                    tMax = yearsWeather[i][j];
                }
                if(tMin > yearsWeather[i][j]){
                    tMin = yearsWeather[i][j];
                }
            }
        }
//        minimalnaja i maximalnaja t v godu
        StringBuilder sbDaysWithMaxTemp = new StringBuilder();
        StringBuilder sbDaysWithMinTemp = new StringBuilder();
        for (int i = 0; i < yearsWeather.length; i++) {
            for (int j = 0; j < yearsWeather[i].length; j++) {
                if(tMax == yearsWeather[i][j]){
                    sbDaysWithMaxTemp.append(j+1)
                      .append(" ")
                      .append(month.values()[i])
                      .append(", ");
                }
                if(tMin == yearsWeather[i][j]){
                    sbDaysWithMinTemp.append(j+1)
                      .append(" ")
                      .append(month.values()[i])
                      .append(", ");
                }
                
            }
        }
        
        System.out.print("Максимальная температура в году "+ tMax);
        System.out.println(" была: "+ sbDaysWithMaxTemp);
        System.out.print("Минимальная температура в году "+ tMin);
        System.out.println(" была: "+ sbDaysWithMinTemp);
        System.out.println();
        System.out.println("t дня");
        Scanner scanner = new Scanner(System.in);
            System.out.print("Введите день месяца: ");
            int day = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Введите месяц: ");
            int month = scanner.nextInt();
            System.out.println("В этот день была температура: "
                    +yearsWeather[month-1][day-1]+ " градусов по Цельсию");
    }
}