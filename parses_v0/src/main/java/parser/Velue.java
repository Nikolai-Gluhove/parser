package parser;

import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Velue {

    Parser parser = new Parser();
    public Velue() throws IOException {
    }

    //Выбираем участок с данными
    public Elements velue = parser.getCards().select("tr[class=weather-table__row]");

    private int size = parser.getCards().size();
    private int sizeVelue = velue.size();

    //даты
    private String[] date = new String[size];
    //температура
    private String[] temp = new String[sizeVelue];
    //явление
    private String[] condition = new String[sizeVelue];
    //давление
    private String[] pressure = new String[sizeVelue];
    //влажность
    private String[] humidity = new String[sizeVelue];
    //ветер
    private String[] wrapper = new String[sizeVelue];
    //ощющается как
    private String[] feelsLike = new String[sizeVelue];





    //выборка дат и сразу их перевод в String
    private String[] date() throws IOException {

        String[] dateString = new String[size];

        int x = 0;
        for (int i = 0; i < size;  i++){
            dateString[x] = parser.getCards().get(i).
                    select("span[class=a11y-hidden]").
                    first().
                    text();

            x = x + 1;
        }
        return dateString;
    }

    //выборка температуры и сразу их перевод в String
    private String[] temp() throws IOException {
        String[] tempString = new String[sizeVelue];

        int x = 0;
        for (int i = 0; i < sizeVelue;  i++){
            tempString[x] = velue.get(i).
                    select("span[class=a11y-hidden]").
                    first().
                    text();

            x = x + 1;
        }
        return tempString;
    }

    //выборка явления и сразу их перевод в String
    private String[] condition() throws IOException {
        String[] conditionString = new String[sizeVelue];

        int x = 0;
        for (int i = 0; i < sizeVelue;  i++){
            conditionString[x] = velue.get(i).
                    select("td[class=weather-table__body-cell weather-table__body-cell_type_condition]").
                    first().
                    text();

            x = x + 1;
        }
        return conditionString;
    }

    //выборка давления и сразу их перевод в String
    private String[] pressure() throws IOException {
        String[] pressureString = new String[sizeVelue];

        int x = 0;
        for (int i = 0; i < sizeVelue;  i++){
            pressureString[x] = velue.get(i).
                    select("td[class=weather-table__body-cell weather-table__body-cell_type_air-pressure]").
                    first().
                    text();

            x = x + 1;
        }
        return pressureString;
    }

    //выборка влажности и сразу их перевод в String
/*    private String[] humidity() throws IOException {
        String[] humidityString = new String[sizeVelue];

        int x = 0;
        for (int i = 0; i < sizeVelue;  i++){
            humidityString[x] = velue.get(i).
                    select("td[class=weather-table__body-cell weather-table__body-cell_type_humidity").
                    text();

            x = x + 1;
        }
        return humidityString;
    }*/

    //выборка ветра и сразу их перевод в String
    private String[] wrapper() throws IOException {
        String[] wrapperString = new String[sizeVelue];

        int x = 0;
        for (int i = 0; i < sizeVelue;  i++){
            wrapperString[x] = velue.get(i).
                    select("td[class=weather-table__body-cell weather-table__body-cell_type_wind weather-table__body-cell_wrapper]").
                    select("span[class=a11y-hidden]").
                    first().
                    text();

            x = x + 1;
        }
        return wrapperString;
    }

    //выборка ощющения температуры и сразу их перевод в String
    private String[] feelsLike() throws IOException {
        String[] feelsLikeString = new String[sizeVelue];

        int x = 0;
        for (int i = 0; i < sizeVelue;  i++){
            feelsLikeString[x] = velue.get(i).
                    select("td[class=weather-table__body-cell weather-table__body-cell_type_feels-like]").
                    select("span[class=a11y-hidden]").
                    first().
                    text();

            x = x + 1;
        }
        return feelsLikeString;
    }



    public String[] getDate() throws IOException {
        date = date();
        return date;
    }

    public String[] getTemp() throws IOException {
        temp = temp();
        return temp;
    }

    public String[] getCondition() throws IOException {
        condition = condition();
        return condition;
    }

    public String[] getPressure() throws IOException {
        pressure = pressure();
        return pressure;
    }

/*    public String[] getHumidity() throws IOException {
        humidity = humidity();
        return humidity;
    }*/

    public String[] getWrapper() throws IOException {
        wrapper = wrapper();
        return wrapper;
    }

    public String[] getFeelsLike() throws IOException {
        feelsLike = feelsLike();
        return feelsLike;
    }

    public int getSize() {
        return size;
    }

    public int getSizeVelue() {
        return sizeVelue;
    }
}
