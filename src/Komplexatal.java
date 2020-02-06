// Alexander Jonsson Näslund


public class Komplexatal {
    private double re;
    private double im;

    public Komplexatal(double Re, double Im) {
        this.re = Re;
        this.im = Im;
    }

    public static void main(String[] args) {
        Komplexatal A = new Komplexatal(2.0,3.0);
        Komplexatal B = new Komplexatal(3.0,6.0);
        Komplexatal C = A.add(B);
        Komplexatal D = A.multiply(B);
    }

    private Komplexatal multiply(Komplexatal B) {
        double newre = re* B.re;
        double newim = im * B.im;
        double newre2 = im * B.re;
        double newim2 = re* B.im;
        return new Komplexatal(newre-newre2, newre2+newre);

    }

    public Komplexatal add(Komplexatal B) {
        double newre = re + B.re;
        double newim = im + B.im;
        return new Komplexatal(re+B.re,im+B.im);

    }
}
