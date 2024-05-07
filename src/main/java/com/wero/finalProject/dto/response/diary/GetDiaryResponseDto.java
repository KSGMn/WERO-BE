package com.wero.finalProject.dto.response.diary;

import com.wero.finalProject.common.ResponseCode;
import com.wero.finalProject.common.ResponseMessage;
import com.wero.finalProject.domain.DiaryEntity;
import com.wero.finalProject.domain.UserEntity;
import com.wero.finalProject.dto.response.ResponseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @작성자:최기원
 * @작성날짜:2024/05/04
 * @파일명:GetDiaryResponseDto.class
 * @기능:일기 조회 dto
 **/

@Getter
@NoArgsConstructor
@Setter
public class GetDiaryResponseDto extends ResponseDto {

    private int diary_id;
    private String content;
    private String category;
    private UserEntity writer;

//    public GetPostResponseDto(int post_id,
//                              String content,
//                              String category,
//                              UserEntity writer){
//        super();
//        this.post_id = post_id;
//        this.content = content;
//        this.category = category;
//        this.writer = writer;
//    }

    private GetDiaryResponseDto(DiaryEntity diaryEntity){//엔티티를 받는 생성자
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);//부모로부터 상속받은 프로퍼티들 채워주고
        this.diary_id= diaryEntity.getDiary_id();//전달받은 엔티티의 아이디 받기
        this.content= diaryEntity.getContent();//전달받은 엔티티의 콘텐츠 받기
        this.category= diaryEntity.getCategory();//전달받은 엔티티의 카테고리 받기
        this.writer= diaryEntity.getWriter();//전달받은 엔티티의 작성자 받기
    }

//    private GetPostResponseDto(List<PostEntity> postList){
//        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
//
//        List<GetPostResponseDto> postEntityList=new ArrayList<>();
//        for(PostEntity post:postList) {
//            GetPostResponseDto postEntity=new GetPostResponseDto();
//            postEntity.setPost_id(post.getPost_id());
//            postEntity.setCategory(post.getCategory());
//            postEntity.setWriter(writer);
//            postEntity.setContent(content);
//            postEntityList.add(postEntity);
//        }
//
//    }

    public static ResponseEntity<GetDiaryResponseDto> success(DiaryEntity diaryEntity){//serviceImpl로 부터 diaryEntity를 받아서
        GetDiaryResponseDto result = new GetDiaryResponseDto(diaryEntity);//GetDiaryResponseDto를 생성한다. 다른 응답 dto들과는 다르게 엔티티를 넣어서 생성자 호출한다
        return ResponseEntity.status(HttpStatus.OK).body(result);//ResponseEntity에 상태코드와 GetDiaryResponseDto객체 넣어서 리턴한다
    }

//    public static ResponseEntity<GetPostResponseDto> successAll(List<PostEntity> postList){
//        GetPostResponseDto result = new GetPostResponseDto(postList);
//        return ResponseEntity.status(HttpStatus.OK).body(result);
//    }

    public static ResponseEntity<ResponseDto> notExistDiary(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_DIARY,ResponseMessage.NOT_EXIST_DIARY);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);

    }
}
