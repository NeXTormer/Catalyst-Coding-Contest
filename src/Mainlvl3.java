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

        public double getAngle(int alty)
        {
            return Math.toDegrees(Math.atan2(x, alty));
        }

        double angle;


        public double getAngle()
        {
            return Math.toDegrees(Math.atan2(x, y));
        }

        public Point(String x, String y) {
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
            FileReader reader = new FileReader("level3-1.txt");
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

        Point a2 = new Point(out[0].split(" ")[0], out[0].split(" ")[2]);
        Point a1 = new Point(out[0].split(" ")[1], out[0].split(" ")[2]);


        int nrp = Integer.parseInt(out[1]);

        Point[] points = new Point[nrp];

        for(int i = 0; i < nrp; i++)
        {
            points[i] = new Point(out[i + 2].split(" ")[0], out[i + 2].split(" ")[1]);
        }



        ArrayList<Point> op = new ArrayList<>();

        if(a1.getAngle() < 0)
        {
            double a = 90 + Math.abs(a1.getAngle());
            a1.angle = a;
        }
        else
        {
            a1.angle = Math.abs(-90+a1.getAngle());
        }

        if(a2.getAngle() < 0)
        {
            double a = 90 + Math.abs(a2.getAngle());
            a2.angle = a;
        }
        else
        {
            a2.angle = Math.abs(-90+a2.getAngle());
        }

       // System.out.println(a1.angle);

        //System.out.println(a2.angle);

        for(Point p : points)
        {
            if(a1.y > 0)
            {
                if(p.y > 0)
                {

                    if(p.getAngle() < 0)
                    {
                        double a = 90 + Math.abs(p.getAngle());
                        p.angle = a;
                    }
                    else
                    {
                        p.angle = Math.abs(-90+p.getAngle());
                    }
                    //System.out.println(p.angle);
                    if((p.angle < a1.angle) && (p.angle > a2.angle))
                    {
                        if(a1.y > 0)
                        {
                            if(p.y < a1.y)
                            {
                                op.add(p);
                            }

                        }
                        else
                        {
                            if(p.y > a1.y)
                            {
                                op.add(p);
                            }

                        }
                    }
                    else
                    {
                        op.add(p);
                    }
                }
                else
                {
                    op.add(p);
                }
            }
            else
            {
                //linie unten

                if(p.y > 0)
                {
                    op.add(p);
                }
                else
                {
                    //32235354325324534

                    int ay = -a1.y;

                    if(p.getAngle() < 0)
                    {
                        double a = 90 + Math.abs(p.getAngle());
                        p.angle = a;
                    }
                    else
                    {
                        p.angle = Math.abs(-90+p.getAngle());
                    }
                    //System.out.println(p.angle);
                    if((p.getAngle(-p.y) < a1.getAngle(ay)) && (p.getAngle(-p.y) > a2.getAngle(ay)))
                    {
                        if(a1.y > 0)
                        {
                            if(p.y < a1.y)
                            {
                                op.add(p);
                            }

                        }
                        else
                        {
                            if(p.y > a1.y)
                            {
                                op.add(p);
                            }

                        }
                    }
                    else
                    {
                        op.add(p);
                    }

                    //322352323532523
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
