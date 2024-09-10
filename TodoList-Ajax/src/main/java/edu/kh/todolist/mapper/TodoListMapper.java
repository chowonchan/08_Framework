package edu.kh.todolist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.todolist.dto.Todo;

@Mapper // 상속 받은 클래스 생성 후 Bean 등록
public interface TodoListMapper {

	/** 할 일 목록 조회 & (비동기 요청 처리)
	 * @return todoList
	 */
	List<Todo> selectTodoList();

	/** 완료된 할일 개수 조회
	 * @return completeCount
	 */
	int selectCompleteCount();

	/** 할일 추가
	 * @param todo
	 * @return result
	 */
	int todoAdd(Todo todo);

	/**  할일 상세 조회
	 * @param todoNo
	 * @return
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

	

}
