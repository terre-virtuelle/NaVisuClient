/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bzh.terrevirtuelle.navisu.util;

import java.util.Objects;

/**
 *
 * @author Serge Morvan
 * @date 4 oct. 2014
 * NaVisu project
 */
public class Pair<T,K>{

    private T x;

    private K y;

    public Pair() {
    }

    public Pair(T x, K y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get the value of y
     *
     * @return the value of y
     */
    public K getY() {
        return y;
    }

    /**
     * Set the value of y
     *
     * @param y new value of y
     */
    public void setY(K y) {
        this.y = y;
    }

    /**
     * Get the value of x
     *
     * @return the value of x
     */
    public T getX() {
        return x;
    }

    /**
     * Set the value of x
     *
     * @param x new value of x
     */
    public void setX(T x) {
        this.x = x;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pair<?, ?> other = (Pair<?, ?>) obj;
        if (!Objects.equals(this.x, other.x)) {
            return false;
        }
        if (!Objects.equals(this.y, other.y)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pair{" + "x=" + x + ", y=" + y + '}';
    }

   
}
