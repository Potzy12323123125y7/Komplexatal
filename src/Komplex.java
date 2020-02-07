import java.util.Objects;

import static java.lang.StrictMath.atan;

/*
Alexander Jonsson Näslund

*/
public class Komplex {
    private double re;
    private double im;

    public Komplex(double Re, double Im) { //Skapar två tal, im och re.
        this.re = Re;
        this.im = Im;
    }

    @Override
    public String toString() { //Gör om det komplexatalet till en sträng som kan skrivas ut med System.out.print
        return "Komplex{" +
                "re=" + re +
                ", im=" + im +
                '}';
    }

    @Override
    public boolean equals(Object o) { //Kollar så att två komplexatal är lika varandra.
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Komplex komplex = (Komplex) o;
        return Double.compare(komplex.re, re) == 0 &&
                Double.compare(komplex.im, im) == 0;
    }

    @Override
    public int hashCode() { //Sparar unik hashcode. Så att equals fungerar.
        return Objects.hash(re, im);
    }

    public static void main(String[] args) {
        Komplex A = new Komplex(3.0,2.0); //Skapar Komplextal A
        Komplex B = new Komplex(4.0,1.0); //Skapar Komplextal B
        Komplex C = A.add(B); //Skapar Komplextal C genom att addera A med B (A+B)
        Komplex D = A.multiply(B); //Skapar Komplexatal D genom att multiplicera A med B
        Komplex G = new Komplex (7,3); //Ett nytt Komplextal G som borde vara A adderat med B G =(A+B)
        double E = arg(A); //Skapar en redian av Komplextal A
        System.out.println(E);
        if (C.equals(G)) { //Kollar ifall C = G Alltså ifall add funktionen fungerar.
            System.out.println("apan är glad, (Add funkar)"); // Skriver ut att apan är glad, ifall add fungerar
        }
        else {
            System.out.println("apan är inte glad, (Add funkar inte)"); //Skriver ut att apan inte är glad, ifall add inte fungerar
        }
    }

    private static double arg(Komplex A) { //Det komplexatalet As radian. Skickar sedan tillbaka radianen av A
        double radian;
        double C = (A.im / A.re);
        radian = atan(C);
        return radian;
    }


    private Komplex multiply(Komplex B) { //Multiplicerar de komplexatalen A och B.
        double newre = re* B.re; // reala delen av A multiplicerar med B. osv
        double newim = im * B.im;
        double newre2 = im * B.re;
        double newim2 = re* B.im;
        return new Komplex(newre-newre2, newre2+newre);
    }

    public Komplex add(Komplex B) { //Komplexatalet A adderas med Komplextal B
        double newre = re + B.re;
        double newim = im + B.im;
        return new Komplex(re+B.re,im+B.im);

    }
}
