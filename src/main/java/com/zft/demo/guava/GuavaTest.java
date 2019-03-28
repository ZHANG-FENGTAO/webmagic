package com.zft.demo.guava;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Table;

import java.util.*;

/**
 * @author zft
 * @date 2019/3/25.
 */
public class GuavaTest {

	public static void main(String[] args) {
//		Integer integer = 1;
//		Optional<String> s = Optional.of(integer).map(input -> "2");
//		System.out.println(s.get());
//
//		String jkl = MoreObjects.toStringHelper("jkl").add("1", true).toString();
//		System.out.println(jkl);
//
//		int result = ComparisonChain.start().compare(2, 2).compare(2, 1, Ordering.natural().nullsLast()).result();
//		System.out.println(result);
//
//		// 不可变集合
//		ImmutableSet<String> set = ImmutableSet.<String>builder().add("a").add("b").add("c").build();
//		String ss = set.asList().get(2);
//		System.out.println(ss);
//
//		ImmutableSet<String> of = ImmutableSet.of("a", "b", "c", "d", "e");
//		List<String> list = Arrays.asList("a", "b", "c");
//		ImmutableList<String> strings = ImmutableList.copyOf(list);
//		System.out.println(strings.size());

//		Multiset<String> multiset = HashMultiset.create();
//		TreeMultiset<Comparable> comparables = TreeMultiset.create();
//		LinkedHashMultiset<Object> objects = LinkedHashMultiset.create();
//		multiset.add("a");
//		multiset.add("a");
//		multiset.add("b");
//		int a = multiset.count("a");
//		System.out.println("包含重复元素的个数  " + multiset.size());
//		System.out.println("不包含重复元素的个数 " + multiset.elementSet().size());
//		// 可以统计每个元素出现的个数
//		System.out.println("元素a出现的次数 " + a);
//
//		SortedMultiset<String> sortedMultiset = TreeMultiset.create();
//		sortedMultiset.add("a");
//		sortedMultiset.add("b");
//		sortedMultiset.add("c");
//		sortedMultiset.add("d");
//		sortedMultiset.add("e");
//		SortedMultiset<String> strings = sortedMultiset.subMultiset("a", BoundType.CLOSED, "e", BoundType.OPEN);
//		/*
//			输出：abcd
//		 */
//		strings.forEach(System.out::print);

//		ArrayListMultimap<String, Integer> multimap = ArrayListMultimap.create();
//		multimap.put("a", 1);
//		multimap.put("a", 2);
//		multimap.put("a", 3);
//		multimap.put("a", 4);
//		multimap.put("b", 1);
//		System.out.println(multimap.size());
//
//		//  asMap() 提供Map<K,Collection<V>>形式的视图 collections 中
//		//  a->{1,2,3,4}
//		//  b->{1}
//		Collection<Collection<Integer>> collections = multimap.asMap().values();
//
//		// values {1,2,3,4,1}
//		Collection<Integer> values = multimap.values();
//
//		Collection<Map.Entry<String, Integer>> entries = multimap.entries();
//		entries.forEach(item -> {
//			System.out.print("key--->" + item.getKey());
//			System.out.println("  value--->" + item.getValue());
//		});

//		RangeSet<Integer> rangeSet = TreeRangeSet.create();
//		// 闭区间 [1,10]
//		rangeSet.add(Range.closed(1, 10));
//		// 左闭右开区间 [11,15) 如果左边为11 则和上边的区间为不连续区间  如果左边为10 则两个区间进行合并
//		rangeSet.add(Range.closedOpen(11, 15));
//		// 返回包含指定元素的区间，如果没有这样的区间则返回null
//		Range<Integer> integerRange = rangeSet.rangeContaining(5);
//		// 返回包含rangeSet 所有区间的最小区间
//		Range<Integer> span = rangeSet.span();
//		System.out.println(integerRange);
//		System.out.println(span);

		Table<String, Integer, String> table = HashBasedTable.create();
		table.put("a", 1, "第一个值");
		table.put("a", 2, "第二个值");
		table.put("a", 3, "第三个值");
		table.put("b", 1, "第一个值");
		table.put("b", 4, "第四个值");

		Map<Integer, String> a = table.row("a");
		Map<Integer, String> b = table.row("b");
		Map<String, String> column = table.column(1);
		Set<Table.Cell<String, Integer, String>> cells = table.cellSet();
		Map<Integer, Map<String, String>> columnMap = table.columnMap();
		Collection<String> values = table.values();
		System.out.println("");

		ArrayList<Integer> arrayList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		List<List<Integer>> partition = Lists.partition(arrayList, 2);
		System.out.println(partition);

	}



}
