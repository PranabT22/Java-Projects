import java.util.*;

public class Main {
    static class Player {
        int hp;
        int maxHp;
        int damage;
        String element;
        boolean asleep = false;
        int curseTurns = 0;
        ArrayList<String> inventory = new ArrayList<>();

        Player(int hp, int damage, String element) {
            this.hp = this.maxHp = hp;
            this.damage = damage;
            this.element = element;
        }
    }

    static class Monster {
        String name;
        int hp;
        int maxHp;
        int damage;
        boolean isBoss;
        boolean canSleep;
        boolean canCurse;

        Monster(String name, int hp, int damage, boolean isBoss, boolean canSleep, boolean canCurse) {
            this.name = name;
            this.hp = this.maxHp = hp;
            this.damage = damage;
            this.isBoss = isBoss;
            this.canSleep = canSleep;
            this.canCurse = canCurse;
        }
    }

    static String[] items = {" Heal Potion", "Sword", "Shield", "Magic Leaf", "Ring","Scroll",};
    static Random rand = new Random();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player player = new Player(50, 15, "Fire");

        Monster[] monsters = {
            new Monster("Slime", 20, 7, false, false, false),
            new Monster("Zombie", 22, 8, false, false, false),
            new Monster("Blood Crawler", 25, 9, false, false, false),
            new Monster("Boss 1: Brain Of Cthlu", 35, 12, true, true, false),
            new Monster("Demon", 30, 10, false, false, false),
            new Monster("Tim", 32, 11, false, false, false),
            new Monster("Diabolist", 28, 10, false, false, false),
            new Monster("Voodoo Demon", 34, 12, false, false, false),
            new Monster("Boss 2: Wall Of Flesh", 45, 16, true, false, true)
        };

        System.out.println("Welcome to Player vs Bad Guys!");
        System.out.println("You are Player 1. Defeat all monsters and bosses to win!");
        System.out.println("You have " + player.hp + " HP, element: " + player.element + ", damage: " + player.damage);
        System.out.println("Type 'attack' to attack or 'inventory' to view your items.\n");

        for (int i = 0; i < monsters.length; i++) {
            Monster m = monsters[i];
            System.out.println("A wild " + m.name + " appeared! (HP: " + m.hp + ", Damage: " + m.damage + ")");
            while (m.hp > 0 && player.hp > 0) {
                if (player.asleep) {
                    System.out.println("You are asleep and lose your turn!");
                    player.asleep = false;
                } else {
                    System.out.print("Your HP: " + player.hp + ". " + m.name + " HP: " + m.hp + ".> ");
                    String cmd = sc.nextLine().toLowerCase();
                    if (cmd.equals("attack")) {
                        int playerDmg = player.damage;
                        if (player.curseTurns > 0) {
                            playerDmg = Math.max(1, playerDmg - 5);
                            player.curseTurns--;
                            if (player.curseTurns == 0) System.out.println("The curse has worn off!");
                        }
                        m.hp -= playerDmg;
                        System.out.println("You hit the " + m.name + " for " + playerDmg + " damage.");
                        if (m.hp <= 0) break;
                    } else if (cmd.equals("inventory")) {
                        System.out.println("Inventory: " + (player.inventory.isEmpty() ? "Empty" : player.inventory));
                        continue;
                    } else {
                        System.out.println("Invalid command.");
                        continue;
                    }
                }
                // Monster's turn
                if (m.isBoss && m.canSleep && m.hp > 0 && rand.nextInt(4) == 0) {
                    System.out.println(m.name + " casts Sleep! You fall asleep for 1 turn!");
                    player.asleep = true;
                } else if (m.isBoss && m.canCurse && m.hp > 0 && rand.nextInt(3) == 0) {
                    System.out.println(m.name + " casts Curse! Your damage is reduced for 2 turns!");
                    player.curseTurns = 2;
                } else {
                    player.hp -= m.damage;
                    System.out.println(m.name + " hits you for " + m.damage + " damage.");
                }
            }
            if (player.hp <= 0) {
                System.out.println("You were defeated by " + m.name + ". Game Over.");
                return;
            }
            // Player won, monster drops item and heals
            String drop = items[rand.nextInt(items.length)];
            player.inventory.add(drop);
            System.out.println("You defeated " + m.name + "! It dropped a " + drop + ".");
            m.hp = m.maxHp;

            // Heal player a little after each win
            int heal = 7 + rand.nextInt(20);
            player.hp = Math.min(player.maxHp, player.hp + heal);
            System.out.println("You heal for " + heal + " HP. Current HP: " + player.hp + "\n");
        }

        System.out.println("Congratulations on beating the game!");
        System.out.println("Your final inventory: " + player.inventory);
    }
}
