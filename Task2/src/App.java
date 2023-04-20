import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Task condition:
    Once upon a time there was a rabbit who loved to steal carrots from the gardens of the good software 
    developers. Every time he leaped in a garden, he wanted to collect all the carrots. Can you help the 
    rabbit find how many times he has to jump to eat all the carrots? The gardens are always square, he 
    always enters from the top left corner and he has to jump once for one group of carrots that have no 
    space between each other vertically or horizontally.
*/

/*
Task solution:
    I will cont number of group with carrots(1) and if dont have group with count of carots < 1 I will
    return count of groups - hops else i will return Rabbit cant eat all carots. To count groups i use 
    Depth-First Search witch visits each cell in the garden and if a cell is a 1 and has not been visited 
    yet, it explores all the neighboring cells that are also 1s, marking them as visited and adding them 
    to the group. After that I will save all groups in one List. 
*/


public class App {
    private static Integer[][] inputGarden() {
        // input size of garden
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input size of garden: ");
        int n = scanner.nextInt();

        // input garden
        Integer[][] garden = new Integer[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print("Input element(" + i + ", " + j + "): ");
                garden[i][j] = scanner.nextInt();
            }
        }

        return garden;
    }
    
    private static void printGarden(Integer[][] garden) {
        for(int i = 0; i < garden.length; i++) {
            for(int j = 0; j < garden.length; j++) {
                System.out.print(garden[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer[]>> getCarrotGroups(Integer[][] garden) {
        // create list with groups of carrots
        List<List<Integer[]>> carrotGroups = new ArrayList<>();

        // create array with visited cells
        boolean[][] visitedCells = new boolean[garden.length][garden.length];

        // iterate through garden
        for(int i = 0; i < garden.length; i++) {
            for(int j = 0; j < garden.length; j++) {
                // check current cell have carrot and not be visited
                if(garden[i][j] == 1 && !visitedCells[i][j]) {
                    // create empty group
                    List<Integer[]> carrotGroup = new ArrayList<>();

                    // visit carrout group
                    visitCarrotGroup(garden, visitedCells, i, j, carrotGroup);

                    // add group in carrot groups
                    carrotGroups.add(carrotGroup);
                }
            }
        }

        return carrotGroups;
    }

    private static void visitCarrotGroup(Integer[][] garden, boolean[][] visitedCells, int i, int j, List<Integer[]> carrotGroup) {
        // set this cell as visited
        visitedCells[i][j] = true;

        // add this cell to group
        carrotGroup.add(new Integer[]{i, j});

        // check over cell
        if (i > 0 && garden[i - 1][j] == 1 && !visitedCells[i - 1][j]) {
            visitCarrotGroup(garden, visitedCells, i - 1, j, carrotGroup);
        }
        
        // check under cell
        if (i < garden.length - 1 && garden[i + 1][j] == 1 && !visitedCells[i + 1][j]) {
            visitCarrotGroup(garden, visitedCells, i + 1, j, carrotGroup);
        }

        // check left cell
        if (j > 0 && garden[i][j - 1] == 1 && !visitedCells[i][j - 1]) {
            visitCarrotGroup(garden, visitedCells, i, j - 1, carrotGroup);
        }

        // check right cell
        if (j < garden[0].length - 1 && garden[i][j + 1] == 1 && !visitedCells[i][j + 1]) {
            visitCarrotGroup(garden, visitedCells, i, j + 1, carrotGroup);
        }
    }

    private static void countOfHops(List<List<Integer[]>> carrotGroups) {
        int hops = 0;

        for(List<Integer[]> carrotGroup : carrotGroups) {
            if(carrotGroup.size() == 1) {
                System.out.println("Rabbit cant eat all carrots!");
                return;
            }
            hops++;
        }

        System.out.println("Rabbit need to make " + hops + " hops to eat all carrots.");
    }

    public static void main(String[] args) throws Exception {
        Integer[][] garden = inputGarden();
        printGarden(garden);

        List<List<Integer[]>> carrotGroups = getCarrotGroups(garden);
        countOfHops(carrotGroups);
    }
}
