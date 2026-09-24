public class Motorcycle {
    // Atributos
    private int speed;
    private int gear;
    private int id;
    public static int totMotorcycles = 0;

    // Construtor
    public Motorcycle(int speed, int gear){
        this(speed, gear, totMotorcycles+1001);
        totMotorcycles++;
    }
    public Motorcycle(int speed, int gear, int id){
        this.speed = speed;
        this.gear = gear;
        this.id = id;
    }

    // Métodos
    public int getGear(){
        return gear;
    }
    private void gearUp(){
        if (this.gear < 5) this.gear++;
    }
    public int getSpeed(){
        return speed;
    }
    public void speedUp(int up){
        if(up > 0){
            this.speed += up;
            int marchaIdeal = (int) (this.speed / 20) + 1;
        
            while (this.gear < marchaIdeal && this.gear < 5) {
                gearUp(); 
            }
        }
    }
    public void applyBreaks(int down){
        if(down > 0){
            this.speed -= down;
        }
    }
    public int getId(){
        return id;
    }
}
