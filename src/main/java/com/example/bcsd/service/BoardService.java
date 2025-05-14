package com.example.bcsd.service;

import com.example.bcsd.dto.request.BoardRequest;
import com.example.bcsd.dto.resopnse.BoardResponse;
import com.example.bcsd.exception.CustomException;
import com.example.bcsd.exception.ExceptionMessage;
import com.example.bcsd.model.Board;
import com.example.bcsd.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public List<BoardResponse> getAllBoards() {
        return boardRepository.findAll()
                              .stream()
                              .map(BoardResponse::fromEntity)
                              .toList();
    }

    public BoardResponse getBoardById(Long id) {
        return BoardResponse.fromEntity(
                boardRepository.findById(id)
                                 .orElseThrow(() ->
                                         new CustomException(ExceptionMessage.BOARD_NOT_FOUND)
                                 )
        );
    }

    public BoardResponse createBoard(BoardRequest request) {
        return BoardResponse.fromEntity(
                boardRepository.save(
                        request.toEntity()
                )
        );
    }

    public BoardResponse updateBoardById(Long id, BoardRequest request) {
        Board board = boardRepository
                .findById(id)
                .orElseThrow(() ->
                        new CustomException(ExceptionMessage.ARTICLE_NOT_FOUND)
                )
                .updateBoardName(request.name());

        return BoardResponse.fromEntity(
                boardRepository.save(id, board)
        );
    }

    public void deleteBoardById(Long id) {
        boardRepository.findById(id)
                         .orElseThrow(() ->
                                 new CustomException(ExceptionMessage.BOARD_NOT_FOUND)
                         );

        boardRepository.delete(id);
    }
}
