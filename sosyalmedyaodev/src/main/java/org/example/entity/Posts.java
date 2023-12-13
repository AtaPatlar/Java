package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Posts {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private int ownerId;
        private String postName;

        public Posts(String postName, int ownerId) {
                this.postName = postName;
                this.ownerId = ownerId;
        }
        public Posts() {
        }
        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getPostName() {
                return postName;
        }

        public void setPostName(String postName) {
                this.postName = postName;
        }

        public int getOwnerId() {
                return ownerId;
        }

        public void setOwnerId(int ownerId) {
                this.ownerId = ownerId;
        }


        @Override
        public String toString() {
                return "Posts{" +
                        "id=" + id +
                        ", postName='" + postName + '\'' +
                        ", ownerId=" + ownerId +
                        '}';
        }
}
