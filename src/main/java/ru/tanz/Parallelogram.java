package ru.tanz;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Parallelogram implements Shape {
    double bottomSide;
    double leftSide;
    double angle;

    public double getHeight() {
        return getArea() / bottomSide;
    }

    public void increaseBottomSide(double percent){
        bottomSide = bottomSide + (bottomSide + (percent / 100));
    }
    public void decreaseBottomSide(double percent){
        bottomSide-= bottomSide + (percent / 100);
    }
    public void increaseLeftSide(double percent){
        leftSide+= leftSide + (percent / 100);
    }
    public void decreaseLeftSide(double percent){
        leftSide-= leftSide + (percent / 100);
    }
    public double getFirstDiagonal(){
        return Math.sqrt((leftSide * leftSide) + (bottomSide * bottomSide)
                - 2 * leftSide * bottomSide * Math.ceil(Math.cos(angle)));
    }
    public double getSecondDiagonal(){
        return Math.sqrt((2 * Math.pow(bottomSide, 2))
                - (2 * Math.pow(leftSide, 2)) - Math.pow(getFirstDiagonal(), 2));
    }
    @Override
    public double getArea() {
        return bottomSide * leftSide * Math.ceil(Math.sin(90));
    }
    @Override
    public double getPerimeter() {
        return (bottomSide + leftSide) * 2;
    }
}
