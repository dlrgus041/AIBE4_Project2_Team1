package kr.java.pr1mary.controller.view;

import kr.java.pr1mary.dto.view.ReviewDTO;
import kr.java.pr1mary.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/review")
@RequiredArgsConstructor
public class InsertReviewController {
    private final ReviewService reviewService;

    @GetMapping
    public String reviewPage(
            @RequestParam("userId") Long userId,
            @RequestParam("lessonId") Long lessonId,
            Model model
    ) {
        model.addAttribute("userId", userId);
        model.addAttribute("lessonId", lessonId);
        return "pages/lesson/review";
    }

    @PostMapping
    public String insertReview(@RequestBody ReviewDTO dto) {
        reviewService.saveReview(dto);
        return "redirect:/profile/student?id=%d".formatted(dto.getUserId());
    }
}
