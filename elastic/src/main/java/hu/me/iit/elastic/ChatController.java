package hu.me.iit.elastic;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("chat")
public class ChatController {

    private final ChatMessageRepository chatMessageRepository;

    @PostMapping()
    public void newData(@RequestBody @Valid ChatMessageDto chatMessageDto) {
        chatMessageRepository.save(chatMessageDto.toDocument());
    }

    @GetMapping()
    public Page<ChatMessage> findBySender(@RequestBody @Valid FindByDto senderDto) {
        return chatMessageRepository.findBySender(
                senderDto.getQuery(),
                PageRequest.of(0, 10)
        );
    }

    @GetMapping("/find")
    public Page<ChatMessage> findBySenderOrMessageOrRoomName(@RequestBody @Valid FindByDto query) {
        return chatMessageRepository.findBySenderOrMessageOrRoomName(
                query.getQuery(),
                query.getQuery(),
                query.getQuery(),
                PageRequest.of(0, 10)
        );
    }

}
