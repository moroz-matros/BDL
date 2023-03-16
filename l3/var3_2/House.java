package l3.var3_2;

public class House {
    private Window window;
    private Door door;

    public House(Window window, Door door) {
        this.window = window;
        this.door = door;
    }

    public void LockWithKey() {
        door.lock();
    }

    public void WindowsNumOutput() {
        System.out.println("Number of windows: " + window.getNum());
    }

    public void DoorNumOutput() {
        System.out.println("Number of doors: " + door.getNum());
    }

    @Override
    public String toString() {
        return "House{window=" + window + ", door=" + door + '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((window == null) ? 0 : window.hashCode());
        result = prime * result + ((door == null) ? 0 : door.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        House other = (House) obj;
        if (window == null) {
            if (other.window != null)
                return false;
        } else if (!window.equals(other.window))
            return false;
        if (door == null) {
            if (other.door != null)
                return false;
        } else if (!door.equals(other.door))
            return false;
        return true;
    }
}
