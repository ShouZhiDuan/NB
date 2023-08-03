package com.nb.proto.dto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * TestService
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.32.1)",
    comments = "Source: Test.proto")
public final class TestServiceGrpc {

  private TestServiceGrpc() {}

  public static final String SERVICE_NAME = "TestService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.nb.proto.dto.TestProto.Request,
      com.nb.proto.dto.TestProto.Reply> getTestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "test",
      requestType = com.nb.proto.dto.TestProto.Request.class,
      responseType = com.nb.proto.dto.TestProto.Reply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.nb.proto.dto.TestProto.Request,
      com.nb.proto.dto.TestProto.Reply> getTestMethod() {
    io.grpc.MethodDescriptor<com.nb.proto.dto.TestProto.Request, com.nb.proto.dto.TestProto.Reply> getTestMethod;
    if ((getTestMethod = TestServiceGrpc.getTestMethod) == null) {
      synchronized (TestServiceGrpc.class) {
        if ((getTestMethod = TestServiceGrpc.getTestMethod) == null) {
          TestServiceGrpc.getTestMethod = getTestMethod =
              io.grpc.MethodDescriptor.<com.nb.proto.dto.TestProto.Request, com.nb.proto.dto.TestProto.Reply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "test"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.nb.proto.dto.TestProto.Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.nb.proto.dto.TestProto.Reply.getDefaultInstance()))
              .setSchemaDescriptor(new TestServiceMethodDescriptorSupplier("test"))
              .build();
        }
      }
    }
    return getTestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.nb.proto.dto.TestProto.Request,
      com.nb.proto.dto.TestProto.Reply> getTest2Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "test2",
      requestType = com.nb.proto.dto.TestProto.Request.class,
      responseType = com.nb.proto.dto.TestProto.Reply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.nb.proto.dto.TestProto.Request,
      com.nb.proto.dto.TestProto.Reply> getTest2Method() {
    io.grpc.MethodDescriptor<com.nb.proto.dto.TestProto.Request, com.nb.proto.dto.TestProto.Reply> getTest2Method;
    if ((getTest2Method = TestServiceGrpc.getTest2Method) == null) {
      synchronized (TestServiceGrpc.class) {
        if ((getTest2Method = TestServiceGrpc.getTest2Method) == null) {
          TestServiceGrpc.getTest2Method = getTest2Method =
              io.grpc.MethodDescriptor.<com.nb.proto.dto.TestProto.Request, com.nb.proto.dto.TestProto.Reply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "test2"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.nb.proto.dto.TestProto.Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.nb.proto.dto.TestProto.Reply.getDefaultInstance()))
              .setSchemaDescriptor(new TestServiceMethodDescriptorSupplier("test2"))
              .build();
        }
      }
    }
    return getTest2Method;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TestServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TestServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TestServiceStub>() {
        @java.lang.Override
        public TestServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TestServiceStub(channel, callOptions);
        }
      };
    return TestServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TestServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TestServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TestServiceBlockingStub>() {
        @java.lang.Override
        public TestServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TestServiceBlockingStub(channel, callOptions);
        }
      };
    return TestServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TestServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TestServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TestServiceFutureStub>() {
        @java.lang.Override
        public TestServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TestServiceFutureStub(channel, callOptions);
        }
      };
    return TestServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * TestService
   * </pre>
   */
  public static abstract class TestServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * test方法，格式为"方法名 请求参数 返回参数"
     * </pre>
     */
    public void test(com.nb.proto.dto.TestProto.Request request,
        io.grpc.stub.StreamObserver<com.nb.proto.dto.TestProto.Reply> responseObserver) {
      asyncUnimplementedUnaryCall(getTestMethod(), responseObserver);
    }

    /**
     * <pre>
     * test2
     * </pre>
     */
    public void test2(com.nb.proto.dto.TestProto.Request request,
        io.grpc.stub.StreamObserver<com.nb.proto.dto.TestProto.Reply> responseObserver) {
      asyncUnimplementedUnaryCall(getTest2Method(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getTestMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.nb.proto.dto.TestProto.Request,
                com.nb.proto.dto.TestProto.Reply>(
                  this, METHODID_TEST)))
          .addMethod(
            getTest2Method(),
            asyncUnaryCall(
              new MethodHandlers<
                com.nb.proto.dto.TestProto.Request,
                com.nb.proto.dto.TestProto.Reply>(
                  this, METHODID_TEST2)))
          .build();
    }
  }

  /**
   * <pre>
   * TestService
   * </pre>
   */
  public static final class TestServiceStub extends io.grpc.stub.AbstractAsyncStub<TestServiceStub> {
    private TestServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TestServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * test方法，格式为"方法名 请求参数 返回参数"
     * </pre>
     */
    public void test(com.nb.proto.dto.TestProto.Request request,
        io.grpc.stub.StreamObserver<com.nb.proto.dto.TestProto.Reply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * test2
     * </pre>
     */
    public void test2(com.nb.proto.dto.TestProto.Request request,
        io.grpc.stub.StreamObserver<com.nb.proto.dto.TestProto.Reply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTest2Method(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * TestService
   * </pre>
   */
  public static final class TestServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<TestServiceBlockingStub> {
    private TestServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TestServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * test方法，格式为"方法名 请求参数 返回参数"
     * </pre>
     */
    public com.nb.proto.dto.TestProto.Reply test(com.nb.proto.dto.TestProto.Request request) {
      return blockingUnaryCall(
          getChannel(), getTestMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * test2
     * </pre>
     */
    public com.nb.proto.dto.TestProto.Reply test2(com.nb.proto.dto.TestProto.Request request) {
      return blockingUnaryCall(
          getChannel(), getTest2Method(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * TestService
   * </pre>
   */
  public static final class TestServiceFutureStub extends io.grpc.stub.AbstractFutureStub<TestServiceFutureStub> {
    private TestServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TestServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * test方法，格式为"方法名 请求参数 返回参数"
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.nb.proto.dto.TestProto.Reply> test(
        com.nb.proto.dto.TestProto.Request request) {
      return futureUnaryCall(
          getChannel().newCall(getTestMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * test2
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.nb.proto.dto.TestProto.Reply> test2(
        com.nb.proto.dto.TestProto.Request request) {
      return futureUnaryCall(
          getChannel().newCall(getTest2Method(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TEST = 0;
  private static final int METHODID_TEST2 = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TestServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TestServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TEST:
          serviceImpl.test((com.nb.proto.dto.TestProto.Request) request,
              (io.grpc.stub.StreamObserver<com.nb.proto.dto.TestProto.Reply>) responseObserver);
          break;
        case METHODID_TEST2:
          serviceImpl.test2((com.nb.proto.dto.TestProto.Request) request,
              (io.grpc.stub.StreamObserver<com.nb.proto.dto.TestProto.Reply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TestServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TestServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.nb.proto.dto.TestProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TestService");
    }
  }

  private static final class TestServiceFileDescriptorSupplier
      extends TestServiceBaseDescriptorSupplier {
    TestServiceFileDescriptorSupplier() {}
  }

  private static final class TestServiceMethodDescriptorSupplier
      extends TestServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TestServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TestServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TestServiceFileDescriptorSupplier())
              .addMethod(getTestMethod())
              .addMethod(getTest2Method())
              .build();
        }
      }
    }
    return result;
  }
}
