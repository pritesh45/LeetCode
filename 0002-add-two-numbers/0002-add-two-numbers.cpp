/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* head=NULL;
        ListNode* temp=NULL;
        int carry=0;
        while(l1!=NULL||l2!=NULL||carry!=0){
            int value1=(l1==NULL)?0:l1->val;
            int value2=(l2==NULL)?0:l2->val;
            int value=value1+value2+carry;
            ListNode* newNode=new ListNode(value%10);
            carry=value/10;
            if(head==NULL){
                head=newNode;
                temp=newNode;
            }
            else{
                temp->next=newNode;
                temp=temp->next;
            }
            if(l1!=NULL){
                l1=l1->next;
            }
            if(l2!=NULL){
                l2=l2->next;
            }
        }
        return head;
    }
};