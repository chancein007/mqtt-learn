package com.chancein007.chapter7;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * ʵ��org.eclipse.paho.client.mqttv3.MqttCallback�ӿ�
 * MQTT�Ķ��Ķ˽��յ���Ϣ�󣬻�����������ص����� messageArrived(String topic, MqttMessage message)
 * @author ������
 *
 */
public class MonitorCallback implements MqttCallback {
	

	public MonitorCallback() {
	}

	public void connectionLost(Throwable cause) {

	}

	public void deliveryComplete(IMqttDeliveryToken token) {
	}

	/**
	 * ���MQTT�Ķ��Ķν��յ�����Ϣ
	 */
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		String msg = new String(message.getPayload());
		System.out.println(msg);
	}
}