package com.example.changedaworld.util;

public class ProblemSolver {
    public int[] Num(String s, int i)
    {
        String st = "";
        int p = 1;
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9')
        {
            st += s.charAt(i);
            i += 1;
        }
        return new int[]{p * Integer.parseInt(st), i};
    }

    public int[] Mult(String s, int i)
    {
        int[] res;
        int a = 0;
        if (s.charAt(i) == '(')
        {
            i += 1;
            res = Expr(s, i);
            a = res[0];
            i = res[1];
            i += 1;
        }
        else
        {
            res = Num(s, i);
            a = res[0];
            i = res[1];
        }

        return new int[] {a, i};
    }

    public int[] Sum(String s, int i)
    {
        int a;
        int[] res = new int[2];
        res = Mult(s, i);
        a = res[0];
        i = res[1];
        while (i < s.length() && (s.charAt(i) == ('*') || s.charAt(i) == ('/')))
        {
            char ch = s.charAt(i);
            i += 1;
            int b;
            res = Mult(s, i);
            b = res[0];
            i = res[1];
            if (ch == ('*'))
            {
                a *= b;
            }
            else
            {
                a = a / b;
            }
        }
        return new int[]{a, i};
    }

    public int[] Expr(String s, int i)
    {
        int a;
        int[] res = Sum(s, i);
        a = res[0];
        i = res[1];
        while (i < s.length() && (s.charAt(i) == ('+') || s.charAt(i) == ('-')))
        {
            char ch = s.charAt(i);
            i += 1;
            int b;
            res = Sum(s, i);
            b = res[0];
            i = res[1];
            if (ch == ('+'))
            {
                a += b;
            }
            else
            {
                a -= b;
            }
        }
        return new int[]{a, i};
    }
    public int[] Expr(String s)
    {
        int i = 0;
        int a;
        int[] res = Sum(s, i);
        a = res[0];
        i = res[1];
        while (i < s.length() && (s.charAt(i) == ('+') || s.charAt(i) == ('-')))
        {
            char ch = s.charAt(i);
            i += 1;
            int b;
            res = Sum(s, i);
            b = res[0];
            i = res[1];
            if (ch == ('+'))
            {
                a += b;
            }
            else
            {
                a -= b;
            }
        }
        return new int[]{a, i};
    }
}
