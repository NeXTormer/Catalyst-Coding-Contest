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
        Point[] ob;
        try {
            FileReader reader = new FileReader("level4-4.txt");
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

        int oc = Integer.parseInt(out[0].split(" ")[0]);

        ob = new Point[oc];
        for(int i = 0; i < oc; i++)
        {
            ob[i] = new Point(out[i + 1].split(" ")[0], out[i + 1].split(" ")[2]);
        }

        int nrp = Integer.parseInt(out[oc + 1]);

        Point[] points = new Point[nrp];

        for(int i = 0; i < nrp; i++)
        {
            points[i] = new Point(out[i + oc + 2].split(" ")[0], out[i + 2 + oc].split(" ")[1]);
        }



        ArrayList<Point> op = new ArrayList<>();

        for(Point a : ob)
        {
            if(a.getAngle() < 0)
            {
                double h = 90 + Math.abs(a.getAngle());
                a.angle = h;
            }
            else
            {
                a.angle = Math.abs(-90+a.getAngle());
            }

            if(a.getAngle() < 0)
            {
                double h = 90 + Math.abs(a.getAngle());
                a.angle = h;
            }
            else
            {
                a.angle = Math.abs(-90+a.getAngle());
            }

            // System.out.println(a.angle);

            //System.out.println(a.angle);

            for(Point p : points)
            {
                if(a.y > 0)
                {
                    if(p.y > 0)
                    {

                        if(p.getAngle() < 0)
                        {
                            double h = 90 + Math.abs(p.getAngle());
                            p.angle = h;
                        }
                        else
                        {
                            p.angle = Math.abs(-90+p.getAngle());
                        }
                        //System.out.println(p.angle);
                        if((p.angle < a.angle) && (p.angle > a.angle))
                        {
                            if(a.y > 0)
                            {
                                if(p.y < a.y)
                                {
                                    if(!op.contains(p))
                                    op.add(p);
                                }

                            }
                            else
                            {
                                if(p.y > a.y)
                                {
                                    if(!op.contains(p))
                                    op.add(p);
                                }

                            }
                        }
                        else
                        {
                            if(!op.contains(p))
                            op.add(p);
                        }
                    }
                    else
                    {
                        if(!op.contains(p))
                        op.add(p);
                    }
                }
                else
                {
                    //linie unten

                    if(p.y > 0)
                    {
                        if(!op.contains(p))
                        op.add(p);
                    }
                    else
                    {
                        //32235354325324534

                        int ay = -a.y;

                        if(p.getAngle() < 0)
                        {
                            double h = 90 + Math.abs(p.getAngle());
                            p.angle = h;
                        }
                        else
                        {
                            p.angle = Math.abs(-90+p.getAngle());
                        }
                        //System.out.println(p.angle);
                        if((p.getAngle(-p.y) < a.getAngle(ay)) && (p.getAngle(-p.y) > a.getAngle(ay)))
                        {
                            if(a.y > 0)
                            {
                                if(p.y < a.y)
                                {
                                    if(!op.contains(p))
                                    op.add(p);
                                }

                            }
                            else
                            {
                                if(p.y > a.y)
                                {
                                    if(!op.contains(p))
                                    op.add(p);
                                }

                            }
                        }
                        else
                        {if(!op.contains(p))

                            op.add(p);
                        }

                        //322352323532523
                    }
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
