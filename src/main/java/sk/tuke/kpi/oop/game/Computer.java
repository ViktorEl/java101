package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Computer extends AbstractActor {


    public Computer() {

        Animation animation = new Animation("sprites/computer.png", 80, 48, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
        setAnimation(animation);


    }

    public int add(int operand1, int operand2) {
        int result;
        result = operand1 + operand2;
        return result;
    }

    public int sub(int operand1, int operand2) {
        return operand1 - operand2;

    }

}
