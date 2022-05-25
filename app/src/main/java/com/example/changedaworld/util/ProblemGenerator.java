package com.example.changedaworld.util;

import java.util.Random;

public class ProblemGenerator {

    int length;

    public ProblemGenerator(int length) {
        this.length = length;
    }


    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String E(int len)
    {
        Random rand = new Random();
        if (len <= this.length && len > 0) {
            int l = rand.nextInt(4) + 1;
            if (l == 1)
            {
                return "T1+E";
            }else if(l == 2)
            {
                return "T1-E";
            }
            else if(l == 3)
            {
                return "T1";
            }
        }
        else if(len > this.length){
            return "T1";
        }
        else if(len == -1)
        {
            int l = rand.nextInt(3) + 1;
            if (l == 1)
            {
                return "T1+E";
            }
            else if (l == 2)
            {
                return "T1-E";
            }

        }
        return "T1";
    }

    public String T1(int len)
    {
        Random rand = new Random();
        if (len < this.length)
        {
            int l = rand.nextInt(4) + 1;
            if (l == 1)
            {
                return "T2*T1";
            }
            else if (l == 2)
            {
                return "T2";
            }
            else if (l == 3)
            {
                return "T2";
            }

        }
        return "T2";
    }

    public String T2()
    {
        return "T3";
    }

    public String T3(int len)
    {
        Random rand = new Random();
        if (len < this.length) {
            int l = rand.nextInt(3) + 1;
            if (l == 1)
            {
                return nums();
            }
            else if (l == 2)
            {
                String et3 = E(-1);
                String st3 = "(" + et3 + ")";
                return st3;
            }
        }
        return nums();
    }

    public String nums()
    {
        Random rand = new Random();
        return String.valueOf(rand.nextInt(10) + 1);
    }

    public String Gen(String st)
    {
        while (st.contains("E") || st.contains("T1") || st.contains("T2") || st.contains("T3"))
        {
            StringBuffer stringBuffer = new StringBuffer(st);
            if(st.contains("E"))
            {
                int i = st.indexOf("E");
                st = stringBuffer.delete(i, i + "E".length()).insert(i, E(st.length())).toString();
            }
            if (st.contains("T1"))
            {
                int i = st.indexOf("T1");
                st = stringBuffer.delete(i, i + "T1".length()).insert(i, T1(st.length())).toString();
            }
            if (st.contains("T2"))
            {
                int i = st.indexOf("T2");
                st = stringBuffer.delete(i, i + "T2".length()).insert(i, T2()).toString();
            }
            if (st.contains("T3"))
            {
                int i = st.indexOf("T3");
                st = stringBuffer.delete(i, i + "T3".length()).insert(i, T3(st.length())).toString();
            }
        }
        return st;
    }

    public String Gen()
    {
        String st = "E";
        while (st.contains("E") || st.contains("T1") || st.contains("T2") || st.contains("T3"))
        {
            StringBuffer stringBuffer = new StringBuffer(st);
            if(st.contains("E"))
            {
                int i = st.indexOf("E");
                st = stringBuffer.delete(i, i + "E".length()).insert(i, E(st.length())).toString();
            }
            if (st.contains("T1"))
            {
                int i = st.indexOf("T1");
                st = stringBuffer.delete(i, i + "T1".length()).insert(i, T1(st.length())).toString();
            }
            if (st.contains("T2"))
            {
                int i = st.indexOf("T2");
                st = stringBuffer.delete(i, i + "T2".length()).insert(i, T2()).toString();
            }
            if (st.contains("T3"))
            {
                int i = st.indexOf("T3");
                st = stringBuffer.delete(i, i + "T3".length()).insert(i, T3(st.length())).toString();
            }
        }
        return st;
    }
}
