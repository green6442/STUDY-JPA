package jpabook.jpashop;

import jpabook.jpashop.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        // 하나만 생성하여 애플리케이션 전체 공유
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // 쓰레드마다 공유 X , 사용하고 버리기
        EntityManager em = emf.createEntityManager();

        // JPA의 모든 데이터 변경은 트랜잭션 안에서 실행
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("김수빈");

            em.persist(book);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            // 영속성 콘텍스트 종료
            em.close();
        }

        emf.close();
    }
}
