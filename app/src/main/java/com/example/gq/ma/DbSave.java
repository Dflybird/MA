package com.example.gq.ma;

import com.example.gq.ma.bean.History;
import com.example.gq.ma.bean.Robot;
import com.example.gq.ma.bean.Target;
import com.example.gq.ma.bean.Task;
import com.example.gq.ma.bean.Terrain;

import java.util.Random;

public class DbSave {

    public static void save(){
        //                        1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20
        int terrainDetect[]    = {2, 3, 2, 6, 4, 3, 1, 4, 3, 6, 5, 4, 0, 3, 3, 2, 3, 2, 2, 4};
        int terrainNotDetect[] = {2, 3, 1, 0, 2, 2, 4, 0, 4, 1, 0, 3, 4, 3, 5, 2, 0, 3, 4, 1};
        int targetTransport[]  = {5, 1, 2, 2, 1, 5, 3, 2, 4, 0, 1, 2, 3, 3, 6, 4, 3, 4, 1, 3};
        int targetNotTransport[]={0, 3, 2, 4, 5, 1, 3, 3, 1, 4, 3, 4, 2, 1, 0, 2, 2, 1, 4, 2};
        //
        int robotDetect[]      = {2, 3, 2, 2, 2, 3, 2, 3, 2, 4, 2, 3, 2, 3, 4, 2, 3, 3, 3, 2};
        int robotTransport[]   = {3, 2, 2, 2, 4, 3, 4, 3, 2, 3, 3, 3, 2, 4, 3, 3, 3, 2, 3, 3};
        int robotHistory1[]    = {7, 8, 5, 6, 5, 7, 5, 7, 7, 5, 4, 7, 8, 6, 8, 5, 6, 7, 6, 6};
        int robotHistory2[]    = {4, 5, 7, 5, 5, 9, 6, 8, 6, 5, 5, 8, 7, 6, 5, 5, 6, 7, 5, 7};
        //存放总共20条任务

        Random randomT = new Random(500);
        for (int i = 0; i < 20 ; i++)
        {
            Task task;
            //存储任务
            {
                task = new Task();
                task.setDate("2018-4-" + Integer.toString(1 + (i/2)));
                task.setTitle("任务 代号:" + Math.abs(randomT.nextLong()%10000));
            }
            //存储地形
            {
                Random random = new Random(i * 2);
                for (int j = 0; j < terrainDetect[i]; j++){
                    Terrain terrain = new Terrain();
                    terrain.setName("地形d"+j*3);
                    terrain.setDetect(true);
                    terrain.setLastDetectTime("2018-3-" + Integer.toString(1 + (j/2)));
                    terrain.setLocation("("+ Math.abs(random.nextInt()%100)+ "," + Math.abs(random.nextInt()%100) + ")");
                    terrain.save();
                    task.getTerrains().add(terrain);
                }
                for (int j = 0; j < terrainNotDetect[i]; j++){
                    Terrain terrain = new Terrain();
                    terrain.setName("地形d"+j*3);
                    terrain.setDetect(false);
                    terrain.setLastDetectTime("2018-3-" + Integer.toString(1 + (j/2)));
                    terrain.setLocation("("+ Math.abs(random.nextInt()%100) + "," + Math.abs(random.nextInt()%100) + ")");
                    terrain.save();
                    task.getTerrains().add(terrain);
                }
            }
            //存储目标
            {
                Random random = new Random(i * 3);
                for (int j = 0; j < targetTransport[i]; j++){
                    Target target = new Target();
                    target.setName("目标m"+j*3);
                    target.setTransport(true);
                    target.setLastTransportTime("2018-3-" + Integer.toString(1 + (j/2)));
                    target.setLocation("("+ Math.abs(random.nextInt()%100) + "," + Math.abs(random.nextInt()%100) + ")");
                    target.save();
                    task.getTargets().add(target);
                }
                for (int j = 0; j < targetNotTransport[i]; j++){
                    Target target = new Target();
                    target.setName("目标m"+j*3);
                    target.setTransport(false);
                    target.setLastTransportTime("2018-3-" + Integer.toString(1 + (j/2)));
                    target.setLocation("("+ Math.abs(random.nextInt()%100) + "," + Math.abs(random.nextInt()%100) + ")");
                    target.save();
                    task.getTargets().add(target);
                }
            }

            //存储机器人
            {
                Random random = new Random(i * 5);
                for (int j = 0; j < robotDetect[i]; j++){
                    Robot robot = new Robot();
                    robot.setName("探测机器人t"+(j+2300));
                    robot.setDistance(Math.abs(random.nextInt()%1000));
                    robot.setElectric(Math.abs(random.nextInt()%100));
                    robot.setDetect(true);
                    // 存储历史
                    {
                        for (int k = 0; k < robotHistory1[i]; k++){
                            History history = new History();
                            history.setDate("2018-3-" + Integer.toString(20 + k));
                            history.setDistance(Math.abs(random.nextInt()%1000));
                            history.setTarget("探测地形");
                            history.setLocation("("+ Math.abs(random.nextInt()%100) + "," + Math.abs(random.nextInt()%100) + ")");
                            history.setRunTime(Integer.toString(Math.abs(random.nextInt() % 48)));
                            history.save();
                            robot.getHistories().add(history);
                        }
                    }
                    robot.save();
                    task.getRobots().add(robot);
                }
                for (int j = 0; j < robotTransport[i]; j++){
                    Robot robot = new Robot();
                    robot.setName("运输机器人r"+(j+3700));
                    robot.setDistance(Math.abs(random.nextInt()%1000));
                    robot.setElectric(Math.abs(random.nextInt()%100));
                    robot.setDetect(false);
                    // 存储历史
                    {
                        for (int k = 0; k < robotHistory2[i]; k++){
                            History history = new History();
                            history.setDate("2018-3-" + Integer.toString(20 + k));
                            history.setDistance(Math.abs(random.nextInt()%1000));
                            history.setTarget("运输物品");
                            history.setLocation("("+ Math.abs(random.nextInt()%100) + "," + Math.abs(random.nextInt()%100) + ")");
                            history.setRunTime(Integer.toString(Math.abs(random.nextInt() % 48)));
                            history.save();
                            robot.getHistories().add(history);
                        }
                    }
                    robot.save();
                    task.getRobots().add(robot);
                }
            }
            task.save();
        }

    }
}
