package packageclasses;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collections;

//java.lang의 클래스
class Student2{
        private String name;
    
        public Student2(String name) {
            this.name = name;
        }

    }

public class JavaLangprac {

    class Student {
        private String name;
    
        public Student(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "my name is "+name;
        }

    }

    public static void main(String[] args) {

        JavaLangprac p = new JavaLangprac();
        //중첩 클래스
        JavaLangprac.Student s = p.new Student("a");
        //외부 클래스
        Student2 ss = new Student2("a");

        //Object
        /* Object의 getClass()메서드로 Class<T>리턴한 후에 getName() 사용하는 방법  */
        System.out.println(s.getClass().getName()); //ch12.JavaLangprac$Student
        System.out.println(ss.getClass().getName()); //ch12.Student2
        System.out.println(s.hashCode());//1521118594
        System.out.println(ss.hashCode());//1940030785
        System.out.println(s);//my name is a
        System.out.println(ss);//ch12.Student2@73a28541  -> class명@해시코드


        //Class
        /* 더이상 상속할 수 없는 final class인 Class<T>를 바로 사용하는 방법 */
        System.out.println(Student.class.getName());//ch12.JavaLangprac$Student
        System.out.println(Student2.class.getName());//ch12.Student2
        System.out.println(Student.class.getPackage());//package ch12

        System.out.println(String.join("-", "a", "b"));
        System.out.println(Class.class.getName());//java.lang.Class

        //Java.lang.Math
        System.out.println(Math.abs(-1));//1
        System.out.println(Math.max(1, 3));//3
        System.out.println(Math.min(-1,2));//-1
        System.out.println(Math.pow(2, 2));//4.0
        System.out.println(Math.sqrt(4));//2.0
        System.out.println((int) Math.random() * 10);//0~9
        System.out.println(Math.ceil(2.4));//3.0
        System.out.println(Math.round(2.4));//2
        System.out.println(Math.floor(2.4));//2.0

        //String
        String s1 = new String("abc");
        String s2 = "abc";
        String s3 = new String(new char[] { 'a', 'b', 'c' });

        System.out.println(s1);//abc
        System.out.println(s2);//abc
        System.out.println(s3);//abc
        System.out.println(s1.equals(s2));//true
        for(int i=0;i<s1.length();i++) System.out.print(s1.charAt(i) + ",");//a,b,c,
        if(s1.contains("a")) System.out.println("yes, it cotains a");
        System.out.println(s1.concat(s2));//abcabc
        System.out.println(s1.isEmpty());//false
        System.out.println(String.join("-", "d", "e", "f"));//d-e-f
        System.out.println(s1.indexOf("c"));//2
        System.out.println(s1.indexOf("d"));//-1
        System.out.println("ddef".lastIndexOf("d"));//1
        System.out.println(s1.length());
        System.out.println(s1.repeat(2));//abcabc
        System.out.println(s1.replace("a", "b"));//bbc
        System.out.println("bbbccc".replaceAll("b", "c"));//cccccc
        System.out.println(Arrays.toString("a.b.c".split("[.]")));//[a, b, c]
        System.out.println("a.b.c".split("[.]"));//[Ljava.lang.String;@7cef4e59
        System.out.println(Arrays.toString("abaabc".split("[b]")));//[a, aa, c]
        System.out.println(s1.substring(1, 3));//bc
        System.out.println(Arrays.toString(s1.toCharArray()));//[a, b, c]
        System.out.println(s1.toUpperCase()); //ABC
        System.out.println(s1.toLowerCase());//abc
        System.out.println("   a ".trim());//a
        System.out.println(String.valueOf(2));//2 int -> String
        System.out.println(String.valueOf('a'));//a char -> String
        //
        /*  String은 reverse가 없다!
         * 아래 3가지 방법으로 뒤집어야 한다!
         */

        //1.StringBuilder, StringBuffer이용하기
        String str = "abc";
        StringBuffer sbb = new StringBuffer(str);
        System.out.println(sbb.reverse().toString());//cba

        //2.char[] 배열로 변환후 뒤집기
        String str2 = "abc";
        char[] arr = str2.toCharArray();
        char[] reversedArr = new char[arr.length];

        for (int i = 0; i < arr.length; i++) {
            reversedArr[arr.length - i - 1] = arr[i];
        }

        System.out.println(new String(reversedArr));//cba

        //3.List로 변환후 Collections.reverse(list) 이용하여 뒤집기
        String str3 = "abc";
        char[] arr2 = str3.toCharArray();
        List<Character> list=new ArrayList<>();
        for(char each:arr2){
            list.add(each);
        }
        Collections.reverse(list);
        System.out.println(list.toString());//[c, b, a]
        System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining()));//cba


        //StringBuffer 멀티스레드환경에 유리, 문자열을 추가하거나 변경할 때 
        StringBuffer sb = new StringBuffer();
        sb.append("hello, ");
        sb.append("nice to meet you");
        sb.append(2);
        System.out.println(sb.toString()); //hello, nice to meet you2
        System.out.println(sb.capacity()); //34
        sb.delete(23, 24);
        System.out.println(sb.toString()); //hello, nice to meet you
        sb.insert(6, "jeein");
        System.out.println(sb.toString()); //hello,jeein nice to meet you
        System.out.println(sb.reverse().toString());//uoy teem ot ecin nieej,olleh

        //StringBuilder StringBuffer보다 성능 우수
        StringBuilder sbBuilder = new StringBuilder();
        sbBuilder.append("hello, ");
        sbBuilder.append("nice to meet you");
        sbBuilder.append(2);
        System.out.println(sbBuilder.toString());//hello, nice to meet you2
        sbBuilder.delete(23, 24);
        System.out.println(sbBuilder.toString());//hello, nice to meet you
        sbBuilder.insert(6, "jeein");
        System.out.println(sbBuilder.toString()); //hello,jeein nice to meet you
        System.out.println(sbBuilder.reverse().toString());//uoy teem ot ecin nieej,olleh
        
    }

}