package edu.kh.project.board.service;

import java.util.Map;

public interface BoardService {

	Map<String, Object> selectBoardList(int boardCode, int cp);

}
