package com.chancein007.chapter7;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MonitorLastWill {

	private static int QOS = 2;
	private static String MQTT_SERVER = "tcp://127.0.0.1:1883";
	private static String CLIENT_ID = "mqtt_subscriber_monotor_0001";
	private static String WILL_TOPIC_NAME = "senor/status";

	/**
	 * ����MQTT��ͨ������
	 * ����MQTT�����ӣ���ҪҪ����MQTT�����������ӵ�ַ�����ӳ�ʱʱ�䣬
	 * �������ʱ���Լ��ͻ��˵�ID
	 * @param clientId
	 * @return
	 * @throws MqttException
	 */
	private MqttClient connect(String clientId) throws MqttException {
		MemoryPersistence persistence = new MemoryPersistence();
		MqttConnectOptions connOpts = new MqttConnectOptions();
		connOpts.setCleanSession(true);
		connOpts.setConnectionTimeout(10);
		connOpts.setKeepAliveInterval(20);
		MqttClient mqttClient = new MqttClient(MQTT_SERVER, clientId, persistence);
		mqttClient.connect(connOpts);
		return mqttClient;
	}

	/**
	 * MQTT�Ķ��Ķ˶���������Ϣ
	 * @param clientId
	 * @param topic
	 * @param qos
	 * @throws MqttException
	 */
	public void subscribe(String clientId, String topic, int qos) throws MqttException {

		MqttClient mqttClient = this.connect(clientId);
		MonitorCallback monitorCallBack = new MonitorCallback();
		mqttClient.setCallback(monitorCallBack);
		if (mqttClient != null) {
			mqttClient.subscribe(topic, qos);
		}

	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MonitorLastWill monitorLastWill = new MonitorLastWill();

		try {
			monitorLastWill.subscribe(CLIENT_ID, WILL_TOPIC_NAME,QOS);
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

}
