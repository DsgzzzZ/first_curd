package com.ddz.demo.po;

import java.util.List;

public class Node {
    private Integer nodeId;
    private String nodeName;
    private String nodeType;
    private List<NodeProperties> nodePropertiesList;

    @Override
    public String toString() {
        return "Node{" +
                "nodeId=" + nodeId +
                ", nodeName='" + nodeName + '\'' +
                ", nodeType='" + nodeType + '\'' +
                ", nodePropertiesList=" + nodePropertiesList +
                '}';
    }

    public Integer getNodeId() {
        return nodeId;
    }

    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public List<NodeProperties> getNodePropertiesList() {
        return nodePropertiesList;
    }

    public void setNodePropertiesList(List<NodeProperties> nodePropertiesList) {
        this.nodePropertiesList = nodePropertiesList;
    }
}
