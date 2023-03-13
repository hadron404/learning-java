package com.example.list;

import com.example.domain.Goods;

import java.util.*;
import java.util.stream.Collectors;

public class MergeList {


	/**
	 * 根据所给对象的属性进行去重并求和
	 */
	public static List<Goods> distinctAndSumProperty(List<Goods> list) {
		if (list == null || list.isEmpty()) {
			return Collections.emptyList();
		}
		final Map<Long, Integer> cache_sum_result = list.stream()
			.collect(Collectors.toUnmodifiableMap(
				Goods::getId,
				Goods::getNumber,
				Integer::sum
			));
		final Map<Long, Integer> cache_flag_added = new HashMap<>();
		return list
			.stream()
			.map(i -> {
				Long key = i.getId();
				if (cache_flag_added.get(key) == null) {
					i.setNumber(cache_sum_result.get(key));
					cache_flag_added.put(key, 1);
					return i;
				}
				return null;
			})
			.filter(Objects::nonNull)
			.collect(Collectors.toList());
	}

	public static List<Goods> distinctAndSumPropertySecondWay(List<Goods> list) {
		if (list == null || list.isEmpty()) {
			return Collections.emptyList();
		}
		return new ArrayList<>(
			list.stream()
				.collect(
					Collectors.toUnmodifiableMap(
						Goods::getId,
						v -> v,
						(v1, v2) -> {
							v1.setNumber(v1.getNumber() + v2.getNumber());
							return v1;
						}
					))
				.values()
		);
	}

}
