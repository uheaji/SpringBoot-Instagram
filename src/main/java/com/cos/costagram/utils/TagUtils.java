package com.cos.costagram.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.cos.costagram.domain.image.Image;
import com.cos.costagram.domain.tag.Tag;

public class TagUtils {

	public static List<Tag> parsingToTagObject(String tags, Image imageEntity) {
		String temp[] = tags.split("#"); // #여행 #바다
		List<Tag> list = new ArrayList<>();
		
		for(int i = 1; i <temp.length; i++) {
			Tag tag = Tag.builder()
					.name(temp[i].trim())
					.image(imageEntity)
					.build();
			list.add(tag);
		}
		
		return list;
	}
	
}
