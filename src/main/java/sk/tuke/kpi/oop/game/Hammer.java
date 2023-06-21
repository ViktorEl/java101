package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Hammer extends AbstractActor {
    // atributy
    private int usages;


    public Hammer() {
        this.usages = 1;
        Animation animation = new Animation("sprites/hammer.png");
        setAnimation(animation);
    }

    public int getUsagges() {
        return this.usages;
    }

    public void use() {
        if (this.usages > 0) {
            this.usages = this.usages - 1;
        }
        if (this.usages == 0) {
            this.getScene().removeActor(this);
        }
    }









}

