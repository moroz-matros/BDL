package l3.var3_2;

public class Door {
    private int num;
    private boolean isLocked;

    public Door(int num) {
        this.num = num;
        this.isLocked = false;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void lock() {
        this.isLocked = true;
    }

    public void unlock() {
        this.isLocked = false;
    }

    @Override
    public String toString() {
        return "Door{num=" + num + ", isLocked=" + isLocked + '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + num;
        result = prime * result + (isLocked ? 1231 : 1237);
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
        Door other = (Door) obj;
        if (num != other.num)
            return false;
        if (isLocked != other.isLocked)
            return false;
        return true;
    }
}
