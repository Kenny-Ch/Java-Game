package com.scnu.manager;

import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
/**
 * @说明 假的加载器
 * @author 12083
 *
 */
public class GameLoad {
	//	图片集合 使用map来进行存储 枚举类型配合移动(拓展)
		public static Map<String,ImageIcon> imgMap;
		static {
			imgMap=new HashMap<>();
			imgMap.put("left", new ImageIcon("image/tank/play1/player1_left.png"));
			imgMap.put("up", new ImageIcon("image/tank/play1/player1_up.png"));
			imgMap.put("right", new ImageIcon("image/tank/play1/player1_right.png"));
			imgMap.put("down", new ImageIcon("image/tank/play1/player1_down.png"));
		}
}
