package parser;

import java.io.IOException;
import java.lang.reflect.Array;

public class View {
    public static void main(String[] args) throws IOException {

        Velue vel = new Velue();
        int size = vel.getSize();


        int i = 0;
        for (i = 0; i < size; i++) {
            System.out.println(vel.getDate()[i] + "     " + " Температура " + "     " + " Явление " + "     " + " Давление " + "     " + " Влажность " + "     " + " Ветер " + "     " + " Ощющается как ");

            int y = 0;
            for (int z = 0; z < 4; y++, z++) {
                System.out.println("        " + vel.getTemp()[y] + "     " + vel.getCondition()[y] + "     " + " " + vel.getPressure()[y] + " vel.getHumidity()[y] " + "     " + vel.getWrapper()[y] + "     " + vel.getFeelsLike()[y]);

            }
        }

    }

}
