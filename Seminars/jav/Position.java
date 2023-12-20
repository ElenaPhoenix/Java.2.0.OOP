package jav;

public class Position {
    public int x;
    public int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distanceFrom(Position position) {
        //return Math.sqrt(Math.pow(this.x - pos.x, 2) + Math.pow(this.y - pos.y, 2));
        //return Math.max(Math.abs(pos.x - this.x), Math.abs(pos.y - this.y));
        return Math.abs(position.x - this.x)+Math.abs(position.y - this.y);
    }

    public Position directionTo(Position destination) {
        return new Position(destination.x - this.x, destination.y - this.y);
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    public boolean equals(Position pos) {
        return this.x == pos.x && this.y == pos.y;
    }}
//     public int getX() {
//         return x;
//     }

//     public void setX(int x) {
//         this.x += x;
//     }

//     public int getY() {
//         return y;
//     }

//     public void setY(int y) {
//         this.y += y;
//     }

//     public double distance(Position defender) {
//         return Math.sqrt((defender.x - x) * (defender.x - x) + (defender.y - y) * (defender.y - y));
//     }
// }

// public class Distance {
// protected BaseHero findClosestEnemy(ArrayList<BaseHero> enemyTeam) {
// BaseHero closestEnemy=enemyTeam.get((0));
// double
// distance=Math.sqrt(Math.pow(enemyTeam.get(0).x-this.x,2)+Math.pow(enemyTeam.get(0).y-this.y,2));
// double minDistance=distance;
// for (BaseHero enemy : enemyTeam) {
// distance=Math.sqrt(Math.pow(enemy.x-this.x,2)+Math.pow(enemy.y-this.y,2));
// if (enemy.hp<0) continue;
// if (minDistance>distance) {
// minDistance=distance;
// closestEnemy=enemy;
// }
// }
// return closestEnemy;
// }
// }
