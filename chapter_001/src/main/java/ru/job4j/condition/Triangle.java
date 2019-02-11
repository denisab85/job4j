package ru.job4j.condition;

/**
 * @author Denis Abakumov
 * @version $Id$
 */
public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Метод вычисления полупериметра по длинам сторон.
     * <p>
     * Формула.
     * <p>
     * (ab + ac + bc) / 2
     *
     * @param ab расстояние между точками a и b
     * @param ac расстояние между точками a и c
     * @param bc расстояние между точками b и c
     * @return Периметр.
     */
    public double semiperimeter(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }

    /**
     * Метод должен вычислить площадь треугольника.
     *
     * @return Вернуть площадь, если треугольник существует, или -1, если треугольника нет.
     */
    public double area() {
        double rsl = -1; // мы устанавливаем значение -1, так как может быть что треугольника нет. Это значение говорит о том, что треугольника нет.
        double ab = this.a.distanceTo(this.b);
        double ac = this.a.distanceTo(this.c);
        double bc = this.b.distanceTo(this.c);
        double p = this.semiperimeter(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            rsl = Math.sqrt(p * ((p - ab) * (p - ac) * (p - bc)));
        }
        return rsl;
    }

    /**
     * Метод проверяет, можно ли построить треугольник с такими длинами сторон.
     *
     * @param ab Длина от точки a до точки b.
     * @param ac Длина от точки a до точки c.
     * @param bc Длина от точки b до точки c.
     * @return true if triangle is valid, false if triangle with given edge lengths cannot exist
     */
    private boolean exist(double ab, double ac, double bc) {
        double p = semiperimeter(ab, ac, bc);
        if (ab >= p || ac >= p || bc >= p)
            return false;
        return (ab <= 0 || ac <= 0 || bc <= 0);
    }
}
