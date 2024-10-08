package edu.kh.todolist.service;

import java.util.List;
import java.util.Map;

import edu.kh.todolist.dto.Todo;

public interface TodoListService {

	/** 할일 목록 조회 + 완료된 할일 개수
	 * @return
	 */
	Map<String, Object> selectTodoList();

	/** 할일 추가
	 * @param todo
	 * @return result
	 */
	int todoAdd(Todo todo);

	/** 할일 상세 조회
	 * @param todoNo
	 * @return todo
	 */
	Todo todoDetail(int todoNo);

	/** 완료 여부 변경
	 * @param todoNo
	 * @return
	 */
	int todoComplete(int todoNo);

	/** 할일 수정
	 * @param todo
	 * @return
	 */
	int todoUpdate(Todo todo);

	/** 할일 삭제
	 * @param todo
	 * @return
	 */
	int todoDelete(int todoNo);

	/** 제목 검색
	 * @param todoNo
	 * @return
	 */
	String searchTitle(int todoNo);

	/** 전체 할 일 개수 조회
	 * @return
	 */
	int getTotalCount();

	/** 완료된 할 일 개수 조회
	 * @return
	 */
	int getCompleteCount();

	/** 할 일 전체 목록(비동기 요청 처리)
	 * @return
	 */
	List<Todo> getTodoList();

}
