package sk.tuke.kpi.oop.game;


import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.gamelib.graphics.Point;


public class Reactor extends AbstractActor {
    private int temperature;
    private boolean state;
    private int damage;
    private Animation normalAnimation;
    private Animation hotAnimation;
    private Animation brokenAnimation;

    private Animation offAnimation;

    public Reactor() {
        this.temperature = 0;
        this.state = false;
        this.damage = 0;

        this.offAnimation = new Animation("sprites/reactor.png");
        setAnimation(offAnimation);

        this.normalAnimation = new Animation(
            "sprites/reactor_on.png",
            80, 80,
            0.1f,
            Animation.PlayMode.LOOP_PINGPONG
        );

        this.hotAnimation = new Animation(
            "sprites/reactor_hot.png",
            80, 80,
            0.1f,
            Animation.PlayMode.LOOP_PINGPONG
        );
        this.brokenAnimation = new Animation(
            "sprites/reactor_broken.png",
            80, 80,
            0.1f,
            Animation.PlayMode.LOOP_PINGPONG
        );


    }

    public int getTemperature() {
        return temperature;
    }

    public int getDamage() {
        return this.damage;
    }

    public void increaseTemperature(int increment) {

        if (increment < 0) {
            return;
        }

        this.temperature = this.temperature + increment;


        if (this.damage == 100) {
            return;
        }

        if (this.temperature >= 6000) {
            this.damage = 100;
        }


        if (this.temperature >= 2000 && this.temperature <= 6000) {
            int damage = this.temperature / 40 - 50;
            if (damage > this.damage) {
                this.damage = damage;
            }
        }

        // update animation
        // if temperature is >= 6000, then broken show reactor
        if (this.temperature >= 6000) {

            setAnimation(this.brokenAnimation);

            // if (4000 <= temperature < 6000), then show hot reactor
        } else if (this.temperature >= 4000) {

            setAnimation(this.hotAnimation);

            // otherwise show normal reactor
        } else {
            setAnimation(this.normalAnimation);
        }
    }

    public void temperatureDecrease(int decrement) {
        if (decrement < 0) {
            return;
        }
        if (this.damage == 100) {
            return;
        }
        if (this.temperature > 0 && this.temperature <= 6000) {
            this.temperature = this.temperature - decrement;
        }
        if (this.temperature >= 6000) {

            setAnimation(this.brokenAnimation);

            // if (4000 <= temperature < 6000), then show hot reactor
        } else if (this.temperature >= 4000) {

            setAnimation(this.hotAnimation);

            // otherwise show normal reactor
        } else {
            setAnimation(this.normalAnimation);
        }

    }

    public void repairWith(Hammer hammer) {
        if (hammer == null) {
            return;
        }
        if (this.damage == 0) {
            return;
        }

        if (this.damage == 100) {
            return;
        }
        if (this.damage < 50) {
            hammer.use();
            this.damage = 0;
            this.temperature = 0;
            setAnimation(normalAnimation);
        }
        else {
            hammer.use();
            this.damage = this.damage - 50;
            this.temperature = 0;
            setAnimation(normalAnimation);
        }

    }

    public void turnOn() {
        this.state = true;
    }

    public void turnOf() {
        this.state = false;
    }

    public boolean isRunning() {
        return this.state;
    }

}
