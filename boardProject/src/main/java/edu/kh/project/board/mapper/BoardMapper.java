package edu.kh.project.board.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import edu.kh.project.board.dto.Board;

@Mapper
public interface BoardMapper {

	/** boardCode가 일치하는 게시글 중 삭제되지 않은 게시글 수 조회
	 * @param boardCode
	 * @return listCount
	 */
	int getListCount(int boardCode);

	/** 지정된 페이지 분량의 게시글 목록 조회
	 * @param boardCode
	 * @param rowBounds
	 * @return boardList
	 */
	List<Board> selectBoardList(int boardCode, RowBounds rowBounds);

	/** 게시글 상세 조회
	 * @param map
	 * @return
	 */
	Board selectDetail(Map<String, Integer> map);

	/** 조회수 1증가
	 * @param boardNo
	 * @return
	 */
	int updateReadCount(int boardNo);

	/** 게시글 좋아요
	 * @param boardNo
	 * @param memberNo
	 * @return
	 */
	int checkBoardLike(@Param("boardNo") int boardNo,
										 @Param("memberNo") int memberNo);

	/** result2 가 0 일때 INSERT
	 * @param boardNo
	 * @param memberNo
	 * @return
	 */
	int insertBoardLike(@Param("boardNo") int boardNo,
			 								@Param("memberNo") int memberNo);

	/** result2 가 1 일때 DELETE
	 * @param boardNo
	 * @param memberNo
	 * @return
	 */
	int deleteBoardLike(@Param("boardNo") int boardNo,
			 								@Param("memberNo") int memberNo);

	/** 게시글 개수 조회
	 * @param boardNo
	 * @return
	 */
	int getLikeCount(int boardNo);


	List<Map<String, String>> selectBoardTypeList();


}
