import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    class Point
    {
        int x;
        int y;

        public Point(String x, String y)
        {
            this.x = Integer.parseInt(x);
            this.y = Integer.parseInt(y);
        }

        @Override
        public String toString()
        {
            return "" + x + " " + y + " ";
        }
    }

    void start()
    {

        StringBuilder text = new StringBuilder();

        try {
            FileReader reader = new FileReader("level1-4.txt");
            BufferedReader breader = new BufferedReader(reader);

            String temp;

            while((temp = breader.readLine()) != null)
            {
                text.append(temp + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] out = text.toString().split("\n");

        int yline = Integer.parseInt(out[0]);
        int nrp = Integer.parseInt(out[1]);

        Point[] points = new Point[nrp];

        for(int i = 0; i < nrp; i++)
        {
            points[i] = new Point(out[i + 2].split(" ")[0], out[i + 2].split(" ")[1]);
        }



        ArrayList<Point> op = new ArrayList<>();

        if(yline < 0)
        {
            for(Point p : points)
            {
                if(p.y > yline)
                {
                    op.add(p);
                }
            }
        }
        else
        {

            for(Point p : points)
            {
                if(p.y < yline)
                {
                    op.add(p);
                }
            }
        }

        for(Point p : op)
        {
            System.out.print(p);
        }

    }
















    public static void main(String[] args) {
        new Main().start();
    }
}
