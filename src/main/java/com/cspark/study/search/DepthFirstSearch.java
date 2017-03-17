package com.cspark.study.search;

import java.util.Scanner;

/**
 * Created by cspark on 2017. 3. 17..
 */
public class DepthFirstSearch {

    static int vertex; //정점의 개수
    static int startVertex; //시작 정점
    static int[][] vertexMap; //인접 행렬 생
    static int[] vertexVisit; //정점의 방문 여부를 가리키는 배열
    static int vt1, vt2;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        vertex = scan.nextInt(); //정점의 개수 입력
        System.out.println(vertex);
        startVertex = Integer.parseInt(scan.nextLine().trim()); //시작할 정점 입력
        vertexMap = new int[vertex+1][vertex+1]; //+1을 시킨 이후는 정점의 시작을 0이아닌 1로시작하기 위해서이다.!
        vertexVisit = new int[vertex+1]; //+1을 시킨 이후는 정점의 시작을 0이아닌 1로시작하기 위해서이다.!

        while(true) {
            vt1 = scan.nextInt();
            vt2 = scan.nextInt();

            if(vt1 < 0 && vt2 < 0) //두 개의 점이 0보다 작을 경우 break;
                break;

            vertexMap[vt1][vt2] = vertexMap[vt2][vt1] = 1; //정점 vt1과 vt2가 연결되었음을 표기
            //인접행렬의 내용을 이해하면 위에 코드를 이해할 수 있습니다. 예를 들어 1정점 2정점이 연결되었으면 [1][2] 와 [2][1] 배열의 자리가 1이된다.

        }

        dfs(startVertex); //dfs를 시작합니다.

    }

    public static void dfs(int start) {
        vertexVisit[start] = 1;

        for(int i = 1; i <=vertex; i++) {
            if(vertexMap[start][i] == 1 && vertexVisit[i] == 0) {
                System.out.println(start + "->" + i + "로 이동합니다");
                dfs(i);
            }
        }
    }



}
