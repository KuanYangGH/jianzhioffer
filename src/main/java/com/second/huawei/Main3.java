package com.second.huawei;


import java.util.*;

/**
 * 笔试第三题：状态机
 * 状态机首先定义状态，根据当前状态得到下一个状态
 * @author yangkuan
 */
public class Main3 {

    class Node {
        String preState;
        String eventSource;
        String object;
        String event;
        String nextState;

        public Node(String preState, String eventSource, String object, String event, String nextState) {
            this.preState = preState;
            this.eventSource = eventSource;
            this.object = object;
            this.event = event;
            this.nextState = nextState;
        }

        public String matchNode(String preState, String eventSource, String event) {
            if ((this.preState.equals(preState) || (this.preState.equals("no finished") && !preState.equals("finished")))
                    && this.eventSource.equals(eventSource)
                    && this.event.equals(event)) {
                return this.nextState;
            }
            return "false";
        }
    }

    Node node1 = new Node("init", "RmApp", "o", "start", "submitted");
    Node node2 = new Node("submitted", "ResourceScheduler", "o", "app_accepted", "scheduled");
    Node node3 = new Node("scheduled", "RmContainer", "o", "container_allocated", "allocated");
    Node node4 = new Node("scheduled", "ApplicationMasterLauncher", "o", "launched", "running");
    Node node5 = new Node("running", "ResourceScheduler", "o", "finished", "finished");
    Node node6 = new Node("no finished", "RmApp", "o", "kill", "killed");
    Node[] nodes = {node1, node2, node3, node4, node5, node6};


    public void transformState(String s) {
        String[] transforms = s.split(" ");
        Map<String,String> objectMap = new HashMap<>();
        for(String transform:transforms){
            String object =transform.split("\\|")[1];
            objectMap.put(object,"init");
        }
        for (String transform : transforms) {
            String[] strings = transform.split("\\|");
            String eventSource = strings[0];
            String object = strings[1];
            String event = strings[2];
            String nextState;
            for (Node node:nodes){
                if (!(nextState = node.matchNode(objectMap.get(object), eventSource, event)).equals("false")) {
                    System.out.println(object + "|" + nextState);
                    objectMap.put(object,new String(nextState));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        new Main3().transformState(s);
    }
}
// RmApp|RmAppAttempt_001|start RmApp|RmAppAttempt_002|start RmApp|RmAppAttempt_001|kill
