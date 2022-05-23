package inflearn.core.order;

public interface OderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);


}
