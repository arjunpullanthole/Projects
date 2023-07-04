package week1;

public class Dolphin extends Mammal{
    boolean canSwim;
    public boolean isCanSwim() {
        return canSwim;
    }
    public void setCanSwim(boolean canSwim) {
        this.canSwim = canSwim;
    }
    public Dolphin(boolean canSwim) {
        this.canSwim = canSwim;
    }
    public Dolphin(boolean canSwim, boolean canWalk){
        this.canSwim = canSwim;
        this.canWalk = canWalk;
    }
    public void print() {
        System.out.println("Dolphin can swim:"+isCanSwim());
        System.out.println("Dolphin can walk:"+isCanWalk());
    }
}
