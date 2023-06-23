package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Light extends AbstractActor {
    private boolean isOn;
    private Animation lightOn;
    private Animation lightOff;

    private boolean isPowered;

    private Reactor reactor;



    public Light() {
        this.isOn = false;
        this.lightOn = new Animation("sprites/light_on.png");
        this.lightOff = new Animation("sprites/light_off.png");
        setAnimation(lightOff);
    }

    public boolean isOn() {
        if (this.isOn) {
            return true;
        } else {
            return false;
        }
    }

    public void toggle() {
        if (this.isOn) {
            this.isOn = false;
            setAnimation(lightOff);
        }
        else if (!this.isOn && this.isPowered) {
            this.isOn = true;
            setAnimation(lightOn);
        }
    }

    public void setElectricityFlow(boolean isPowered) {
        this.isPowered = isPowered;
        if (!this.isPowered) {
            setAnimation(lightOff);
        }
    }

}
