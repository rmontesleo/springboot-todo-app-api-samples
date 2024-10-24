
package com.example.demo.soap.client.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="taskInfo" type="{http://www.soap.demo.example.com/api/taskTracker}TaskInfo"/&gt;
 *         &lt;element name="serviceStatus" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "taskInfo",
    "serviceStatus"
})
@XmlRootElement(name = "getTaskByIdResponse")
public class GetTaskByIdResponse {

    @XmlElement(required = true)
    protected TaskInfo taskInfo;
    protected int serviceStatus;

    /**
     * Gets the value of the taskInfo property.
     * 
     * @return
     *     possible object is
     *     {@link TaskInfo }
     *     
     */
    public TaskInfo getTaskInfo() {
        return taskInfo;
    }

    /**
     * Sets the value of the taskInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskInfo }
     *     
     */
    public void setTaskInfo(TaskInfo value) {
        this.taskInfo = value;
    }

    /**
     * Gets the value of the serviceStatus property.
     * 
     */
    public int getServiceStatus() {
        return serviceStatus;
    }

    /**
     * Sets the value of the serviceStatus property.
     * 
     */
    public void setServiceStatus(int value) {
        this.serviceStatus = value;
    }

}
