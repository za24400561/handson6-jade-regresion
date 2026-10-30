/*Equipo:
    Villalobos Alvarado Alma Belen.
    Saucedo Ortiz Cesar Jesus.
    Beltran Arellano Alison Odalis.
*/  
public class DataSet {
    private final double[] tv        = {230.1, 44.5, 17.2, 151.5, 180.8, 8.7, 57.5, 120.2, 8.6, 199.8};
    private final double[] radio     = { 37.8, 39.3, 45.9,  41.3,  10.8, 48.9, 32.8,  19.6, 2.1,   2.6};
    private final double[] newspaper = { 69.2, 45.1, 69.3,  58.5,  58.4, 75.0, 23.5,  11.6, 1.0,  21.2};
    private final double[] sales     = { 22.1, 10.4,  9.3,  18.5,  12.9,  7.2, 11.8,  13.2, 4.8,  10.6};

    /** Variable independiente única (TV) para SLR y PR. */
    public double[] getX() { return tv; }
    public double[] getY() { return sales; }

    /** Matriz de variables independientes (TV, Radio, Newspaper) para MLR. */
    public double[][] getXMultiple() {
        double[][] m = new double[tv.length][3];
        for (int i = 0; i < tv.length; i++) { m[i][0] = tv[i]; m[i][1] = radio[i]; m[i][2] = newspaper[i]; }
        return m;
    }
}
