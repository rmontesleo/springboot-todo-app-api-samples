
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
 *         &lt;element name="newTask" type="{http://www.soap.demo.example.com/api/taskTracker}TaskInfo"/&gt;
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
    "newTask",
    "serviceStatus"
})
@XmlRootElement(name = "addTaskResponse")
public class AddTaskResponse {

    @XmlElement(required = true)
    protected TaskInfo newTask;
    protected int serviceStatus;

    /**
     * Gets the value of the newTask property.
     * 
     * @return
     *     possible object is
     *     {@link TaskInfo }
     *     
     */
    public TaskInfo getNewTask() {
        return newTask;
    }

    /**
     * Sets the value of the newTask property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskInfo }
     *     
     */
    public void setNewTask(TaskInfo value) {
        this.newTask = value;
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
